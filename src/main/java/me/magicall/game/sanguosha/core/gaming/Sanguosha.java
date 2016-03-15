package me.magicall.game.sanguosha.core.gaming;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import me.magicall.game.sanguosha.core.card.Card;
import me.magicall.game.sanguosha.core.card.CardCfg;
import me.magicall.game.sanguosha.core.gaming.event.Event;
import me.magicall.game.sanguosha.core.Targetable;
import me.magicall.game.sanguosha.core.area.Settlement;
import me.magicall.game.sanguosha.core.area.CardStack;
import me.magicall.game.sanguosha.core.area.HandArea;
import me.magicall.game.sanguosha.core.area.UsedCardStack;
import me.magicall.game.sanguosha.core.card.GamingCard;
import me.magicall.game.sanguosha.core.gaming.option.SelectHeroOptions;
import me.magicall.game.sanguosha.core.gaming.position.Position;
import me.magicall.game.sanguosha.core.gaming.round.HeroTurn;
import me.magicall.game.sanguosha.core.gaming.round.SanguoshaRound;
import me.magicall.game.sanguosha.core.gaming.stage.Stage;
import me.magicall.game.sanguosha.core.gaming.target.BecomingTargetsEvent;
import me.magicall.game.sanguosha.core.gaming.target.TargetSelector;
import me.magicall.game.sanguosha.core.player.GamingPlayer;
import me.magicall.game.sanguosha.core.player.IO;
import me.magicall.game.sanguosha.core.player.Role;
import me.magicall.game.sanguosha.core.rule.Rule;
import me.magicall.game.sanguosha.core.skill.Effect;
import me.magicall.game.sanguosha.core.skill.Skill;
import me.magicall.game.sanguosha.core.skill.SkillEvent;
import me.magicall.game.sanguosha.core.unit.Hero;
import me.magicall.game.sanguosha.core.unit.HeroCfg;
import me.magicall.game.sanguosha.embedded.标准.event.HarmingEvent;
import me.magicall.game.sanguosha.embedded.标准.event.HerosShownEvent;
import me.magicall.game.sanguosha.embedded.标准.event.InitHandEvent;
import me.magicall.game.sanguosha.embedded.标准.event.WarEndEvent;
import me.magicall.game.sanguosha.embedded.标准.event.WarStartEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

/**
 * @author Liang Wenjian
 */
public class Sanguosha implements Game, Targetable {

    //------------------------ 工具

    private final Logger logger = LoggerFactory.getLogger(getClass());

    //------------------------ 配置

    private final SanguoshaCfg cfg;
    private List<IO> ios;
    private List<Rule> rules;

    //------------------------ 初始化数据

    private final List<GamingPlayer> players = Lists.newArrayList();
    /**
     * 武将备选记录。
     */
    private final ListMultimap<GamingPlayer, HeroCfg> heroOptions = ArrayListMultimap.create();

    /**
     * 武将库。
     */
    private final List<HeroCfg> heroCfgs;

    /**
     * 牌库。键为牌在游戏中的id。
     */
    private final Map<Integer, GamingCard> idCardMap = Maps.newHashMap();
    /**
     * 位置管理器
     */
    private final PositionManager positionManager = new PositionManager();

    /**
     * 队伍列表
     */
    private List<Team> teams;
    /**
     * 记分牌
     */
    private Scoreboard scoreboard;

    /**
     * 当前轮次
     */
    private Round curRound;
    /**
     * 当前回合
     */
    private HeroTurn curHeroTurn;
    /**
     * 当前阶段
     */
    private Stage curStage;
    /**
     * 当前玩家
     */
    private GamingPlayer curPlayer;

    //------------------------ 游戏

    /**
     * 存活者。按位置顺序排列。
     */
    private final List<GamingPlayer> survivors = Lists.newArrayList();
    /**
     * 牌堆。
     */
    private final CardStack cardStack = new CardStack(null);//TODO
    /**
     * 结算区。
     */
    private final Settlement settlement = new Settlement();
    /**
     * 弃牌堆。
     */
    private final UsedCardStack usedCardStack = new UsedCardStack();

    /**
     * 轮次。
     */
    private final List<Round> rounds = Lists.newArrayList();
    private boolean gameOver;

    //===============================================

    public Sanguosha(final SanguoshaCfg cfg) {
        this.cfg = cfg;
        final List<HeroCfg> tmp = Lists.newArrayList(cfg.getHeroCfgs());
        Collections.shuffle(tmp);
        heroCfgs = tmp;
    }

    @Override
    public Scoreboard start() {
        initCardStack();
        initPosition();

        selectHero();

        initHand();

        start0();
        return null;
    }

    private void start0() {
        publishEvent(new WarStartEvent(this));
        int roundIndex = 0;
        while (!gameOver) {
            final Round round = new SanguoshaRound(this, roundIndex);
            round.play();
            rounds.add(round);
            roundIndex++;
        }
        publishEvent(new WarEndEvent(this));
    }

    private void initHand() {
        survivors.forEach(player -> {
            final Collection<Card> cards = cardsStackPop(cfg.getInitHandCardsCount());
            final HandArea hand = player.getHero().getHand();
            if (hand.canGain(cards)) {
                hand.gain(cards);
            } else {
                cardStack.gain(cards);
            }
        });
        publishEvent(new InitHandEvent(this));
    }

    private void selectHero() {
        final Map<GamingPlayer, HeroCfg> map = Maps.newLinkedHashMap();
        //选将
        survivors.forEach(player -> {
            final HeroCfg selected = player.requireInput(new SelectHeroOptions(getOptionHeros(player)))//
                    .getHeroCfg();
            player.setHero(new Hero(selected, this, player, player.getPosition()));
            final List<HeroCfg> options = heroOptions.get(player);
            options.remove(selected);
            heroCfgs.addAll(options);//没有选的武将还回武将堆。
            map.put(player, selected);
        });
        //亮武将
        survivors.forEach(player -> player.output(map));
        publishEvent(new HerosShownEvent(this, map));
    }

    public int getCardStackSize() {
        return cardStack.getCards().size();
    }

    public int getRoundCount() {
        return rounds.size() + 1;
    }

    public void publishEvent(final Event<?, ?> event) {
        //TODO
    }

    public int calculateDistance(final Hero from, final Hero to) {
        return positionManager.calculateDistance(from, to);
    }

    private List<HeroCfg> getOptionHeros(final GamingPlayer player) {
        final int size = 3;
        final List<HeroCfg> rt = Lists.newArrayListWithExpectedSize(size);
        for (int i = 0; i < size; i++) {
            final HeroCfg removed = heroCfgs.remove(i);
            rt.add(removed);
        }
        heroOptions.putAll(player, rt);
        return rt;
    }

    private void initPosition() {
        final List<IO> ios = Lists.newArrayList(cfg.getIOs());
        final int size = ios.size();

        final Map<Role, Integer> countOfRole = cfg.getCountOfRole();
        final List<Role> tmpRoles = Lists.newArrayListWithExpectedSize(size);
        for (final Entry<Role, Integer> entry : countOfRole.entrySet()) {
            final Role role = entry.getKey();
            final Integer count = entry.getValue();
            for (int i = 0; i < count; i++) {
                tmpRoles.add(role);
            }
        }
        if (size != tmpRoles.size()) {
            throw new IllegalStateException("玩家和角色不一样多。");
        }
        Collections.shuffle(tmpRoles);

        if (!cfg.isPositionFixed()) {
            Collections.shuffle(ios);
        }
        int i = 1;
        for (final IO io : ios) {
            final Position position = new Position(i);
            final GamingPlayer p = new GamingPlayer();
            p.setRole(tmpRoles.get(i));
            p.setIO(io);
            p.setPosition(position);
            survivors.add(p);
            players.add(p);
            i++;
        }
        survivors.sort((o1, o2) -> o1.getPosition().compareTo(o2.getPosition()));
        logger.debug(ios.toString());
    }

    private void initCardStack() {
        final Map<CardCfg, Integer> cardCfgCount = cfg.getCountOfCardCfg();
        int id = 1;
        final List<Card> cards = Lists.newArrayList();
        for (final Entry<CardCfg, Integer> entry : cardCfgCount.entrySet()) {
            final CardCfg cardCfg = entry.getKey();
            final Integer count = entry.getValue();
            for (int i = 0; i < count; ++i) {
                final GamingCard card = new GamingCard(id, cardCfg);
                cards.add(card);
                idCardMap.put(id, card);
                id++;
            }
        }
        Collections.shuffle(cards);
        cardStack.gain(cards);

        logger.debug("initCardStack end:" + cardStack);
    }

    public List<HeroCfg> getHeroCfgs() {
        return heroCfgs;
    }

    public CardStack getCardStack() {
        return cardStack;
    }

    public Settlement getSettlement() {
        return settlement;
    }

    public UsedCardStack getUsedCardStack() {
        return usedCardStack;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(final boolean gameOver) {
        this.gameOver = gameOver;
    }

    @Override
    public List<GamingPlayer> getPlayers() {
        return players;
    }

    @Override
    public List<Team> getTeams() {
        return teams;
    }

    public void cardWork(final Card card, final Hero user) {
        final Collection<Skill> skills = card.getSkills();
        final Collection<Card> resources = Collections.singleton(card);
        for (final Skill skill : skills) {
            final TargetSelector targetSelector = skill.getTargetSelector();
            final BecomingTargetsEvent becomingTargetsEvent = new BecomingTargetsEvent(
                    targetSelector.getTarget(this, user.getPlayer(), skill), skill);
            publishEvent(becomingTargetsEvent);
            final List<Hero> targets = becomingTargetsEvent.getSource();
            final Effect<?> effect = skill.action(this, user, targets, resources);
            effect.doEffect();
        }

        //TODO
    }

    public Collection<Card> cardsStackPop(final int count) {
        if (cardStack.getCardsCount() < count) {
            //牌堆不够就洗牌
            final List<Card> cards = Lists.newArrayList(usedCardStack.getCards());
            usedCardStack.loss(cards);
            Collections.shuffle(cards);
            cardStack.gain(cards);
            //洗牌后依然不够
            if (cardStack.getCardsCount() < count) {
                throw new NoEnoughCardException();
            }
        }
        return cardStack.poll(count);
    }

    public Card getCard(final Integer cardId) {
        return idCardMap.get(cardId);
    }

    public void heroDead(final Hero hero) {
        //TODO
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + hashCode() + ":{" +
                "cfg:" + cfg +
                '}';
    }

    public void harm(final Hero target, final SkillEvent skillEvent) {
        final HarmingEvent harmingEvent = new HarmingEvent(target, 1);
        publishEvent(harmingEvent);
        final int count = harmingEvent.getCount();
//        target.setHp(target.getHp() - count);
        //TODO
    }

    public GamingPlayer getPlayer(final int position) {
        return null;//TODO
    }

    public Map<GamingPlayer, Integer> calculateAttackables(final GamingPlayer user) {
        return null;//TODO
    }

    public Map<GamingPlayer, Integer> getDistanceScope(final GamingPlayer user) {
        return null;//TODO
    }

    private ListMultimap<Class<?>, Hook<?>> hooks;

    public void hook(final Hook<?> hook) {
        hooks.put(hook.getEventClass(), hook);
    }

    public void doHook(final Event event) {
        final List<Hook<?>> hooks = this.hooks.get(event.getClass());
        if (hooks != null) {
            final ListIterator<Hook<?>> iterator = hooks.listIterator();
            while (iterator.hasNext()) {
                @SuppressWarnings("unchecked")
                final Hook<Event<?, ?>> next = (Hook<Event<?, ?>>) iterator.next();
                next.before(event);
//TODO:有没有中断事件执行这种说法？
//                if (event.isEnd()) {
//                    break;
//                }
            }

            while (iterator.hasPrevious()) {
                @SuppressWarnings("unchecked")
                final Hook<Event<?, ?>> previous = (Hook<Event<?, ?>>) iterator.previous();
                previous.after(event);
            }
        }
    }

    public Skill getSkill(final int skillId) {
        return null;//TODO
    }

    public void skillAction(final Skill skill, final Hero user, final Collection<Card> resources,
                            final List<Hero> targets) {
        skill.action(this, user, targets, resources);
    }

    private static final Random RANDOM = new Random();

    static void initRole(final Map<Role, Integer> roleAndCount, final Collection<GamingPlayer> players) {
        final List<Role> tmp = Lists.newArrayList();
        roleAndCount.entrySet().forEach(e -> {
            final Role role = e.getKey();
            for (int i = 0; i < e.getValue(); i++) {
                tmp.add(role);
            }
        });
        players.stream().forEach(p -> {
            final int index = RANDOM.nextInt(tmp.size());
            final Role role = tmp.get(index);
            tmp.remove(index);
            p.setRole(role);
        });
    }

}
