package me.magicall.game.sanguosha.core.gaming;

import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;
import me.magicall.game.sanguosha.core.CardManager;
import me.magicall.game.sanguosha.core.DefaultAreaManagerImpl;
import me.magicall.game.sanguosha.core.DefaultCardManagerImpl;
import me.magicall.game.sanguosha.core.DefaultHeroManagerImpl;
import me.magicall.game.sanguosha.core.DefaultPlayerManagerImpl;
import me.magicall.game.sanguosha.core.DefaultRoundManager;
import me.magicall.game.sanguosha.core.GameOverException;
import me.magicall.game.sanguosha.core.HeroManager;
import me.magicall.game.sanguosha.core.PlayerManager;
import me.magicall.game.sanguosha.core.area.CardStack;
import me.magicall.game.sanguosha.core.area.Settlement;
import me.magicall.game.sanguosha.core.area.UsedCardStack;
import me.magicall.game.sanguosha.core.card.Card;
import me.magicall.game.sanguosha.core.gaming.event.Event;
import me.magicall.game.sanguosha.core.gaming.event.EventPublisher;
import me.magicall.game.sanguosha.core.gaming.round.RoundEndEvent;
import me.magicall.game.sanguosha.core.gaming.round.SanguoshaTurn;
import me.magicall.game.sanguosha.core.gaming.target.BecomingTargetsEvent;
import me.magicall.game.sanguosha.core.gaming.target.TargetSelector;
import me.magicall.game.sanguosha.core.player.GamingPlayer;
import me.magicall.game.sanguosha.core.player.Role;
import me.magicall.game.sanguosha.core.rule.Rule;
import me.magicall.game.sanguosha.core.skill.Effect;
import me.magicall.game.sanguosha.core.skill.Skill;
import me.magicall.game.sanguosha.core.skill.SkillEvent;
import me.magicall.game.sanguosha.core.unit.Hero;
import me.magicall.game.sanguosha.core.unit.HeroCfg;
import me.magicall.game.sanguosha.embedded.标准.event.HarmingEvent;
import me.magicall.game.sanguosha.embedded.标准.event.WarEndEvent;
import me.magicall.game.sanguosha.embedded.标准.event.WarStartEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Random;

/**
 * @author Liang Wenjian
 */
public class Sanguosha implements Game {

    //------------------------ 工具

    private final Logger logger = LoggerFactory.getLogger(getClass());

    //------------------------ 配置

    /**
     * 本场游戏使用的设置
     */
    private final SanguoshaCfg cfg;
    /**
     * 本场游戏使用的规则集
     */
    private List<Rule> rules;

    //------------------------ 初始化数据

    private final PlayerManager playerManager;

    private final HeroManager heroManager;

    private final CardManager cardManager;
    private final RoundManager roundManager;

    //------------------------ 游戏

    private final AreaManager areaManager;

    private boolean gameOver;

    private EventPublisher eventPublisher;

    //===============================================

    public Sanguosha(final SanguoshaCfg cfg) {
        this.cfg = cfg;
        heroManager = new DefaultHeroManagerImpl(this);
        playerManager = new DefaultPlayerManagerImpl(this);
        areaManager = new DefaultAreaManagerImpl(this);
        roundManager = new DefaultRoundManager(this);
        cardManager = new DefaultCardManagerImpl(this);
    }

    @Override
    public Scoreboard start() {
        //初始化牌堆
        initCardStack();
        //初始化位置
        initPosition();
        //选英雄
        selectHero();
        //分发初始手牌
        initHand();
        //正式开始，发布事件
        publishEvent(new WarStartEvent(this));
        //当游戏未结束
        while (true) {
            try {
                //一轮一轮玩
                final RoundEndEvent roundEndEvent = roundManager.roundPlay();
                publishEvent(roundEndEvent);
            } catch (final GameOverException ignored) {
                break;
            }
        }
        //游戏结束，发布事件
        publishEvent(new WarEndEvent(this));
        //返回记分牌
        return playerManager.getScoreboard();
    }

    private void initHand() {
        playerManager.initHand();
    }

    private void selectHero() {
        playerManager.selectHero();
    }

    public int getCardStackSize() {
        return areaManager.getCardStackSize();
    }

    public int getRoundCount() {
        return roundManager.getFinishedRoundCount();
    }

    public void publishEvent(final Event<?, ?> event) {
        eventPublisher.publish(event);
    }

    public int calculateDistance(final Hero from, final Hero to) {
        return playerManager.calculateDistance(from, to);
    }

    private List<HeroCfg> getOptionHeros(final GamingPlayer player) {
        return heroManager.getOptionHeros(player);
    }

    private void initPosition() {
        playerManager.initPosition();
    }

    private void initCardStack() {
        cardManager.initCardStack();
    }

    public List<HeroCfg> getHeroCfgs() {
        return heroManager.getHeroCfgs();
    }

    public CardStack getCardStack() {
        return areaManager.getCardStack();
    }

    public Settlement getSettlement() {
        return areaManager.getSettlement();
    }

    public UsedCardStack getUsedCardStack() {
        return areaManager.getUsedCardStack();
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(final boolean gameOver) {
        this.gameOver = gameOver;
    }

    @Override
    public List<GamingPlayer> getPlayers() {
        return playerManager.getPlayers();
    }

    @Override
    public List<Team> getTeams() {
        return playerManager.getTeams();
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
        return areaManager.cardStackPop(count);
    }

    public Card getCard(final Integer cardId) {
        return cardManager.getCard(cardId);
    }

    public void heroDead(final Hero hero) {
        //TODO
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

    public void doHook(final Event<?, ?> event) {
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

    public SanguoshaCfg getCfg() {
        return cfg;
    }

    public Skill getSkill(final int skillId) {
        return null;//TODO
    }

    public void skillAction(final Skill skill, final Hero user, final Collection<Card> resources,
                            final List<Hero> targets) {
        skill.action(this, user, targets, resources);
    }

    public List<Rule> getRules() {
        return rules;
    }

    public PlayerManager getPlayerManager() {
        return playerManager;
    }

    public HeroManager getHeroManager() {
        return heroManager;
    }

    public CardManager getCardManager() {
        return cardManager;
    }

    public RoundManager getRoundManager() {
        return roundManager;
    }

    public AreaManager getAreaManager() {
        return areaManager;
    }

    public Round getCurRound() {
        return roundManager.getCurRound();
    }

    public SanguoshaTurn getCurTurn() {
        return getCurRound().getCurTurn();
    }

//    public Stage getCurStage(){
//        return getCurTurn().getCurStage();
//    }

    //============================

    @Override
    public String toString() {
        return getClass().getSimpleName() + hashCode() + ":{" +
                "cfg:" + cfg +
                '}';
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
