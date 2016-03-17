package me.magicall.game.sanguosha.core.player;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import me.magicall.game.sanguosha.core.area.HandArea;
import me.magicall.game.sanguosha.core.gaming.Sanguosha;
import me.magicall.game.sanguosha.core.gaming.SanguoshaCfg;
import me.magicall.game.sanguosha.core.gaming.Scoreboard;
import me.magicall.game.sanguosha.core.gaming.position.Position;
import me.magicall.game.sanguosha.core.unit.Hero;
import me.magicall.game.sanguosha.core.unit.HeroCfg;
import me.magicall.game.sanguosha.embedded.标准.event.HerosShownEvent;
import me.magicall.game.sanguosha.embedded.标准.event.InitHandEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author Liang Wenjian
 */
public class DefaultPlayerManagerImpl implements PlayerManager {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final Sanguosha game;
    /**
     * 玩家列表
     */
    private final List<GamingPlayer> players;
    /**
     * 存活者。按位置顺序排列。
     */
    private final List<GamingPlayer> survivors;
    /**
     * 位置管理器
     */
    private final PositionManager positionManager;
    /**
     * 队伍列表
     */
    private List<Team> teams;
    /**
     * 记分牌
     */
    private Scoreboard scoreboard;
    /**
     * 玩家通道列表
     */
    private List<IO> ios;

    public DefaultPlayerManagerImpl(final Sanguosha game) {
        super();
        this.game = game;
        players = Lists.newArrayList();
        positionManager = new PositionManager();
        survivors = Lists.newArrayList();
    }

    @Override
    public Scoreboard getScoreboard() {
        return scoreboard;
    }

    @Override
    public void initPosition() {
        final SanguoshaCfg cfg = game.getCfg();
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
            final GamingPlayer p = new GamingPlayer(null, null);
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

    @Override
    public void selectHero() {
        final Map<GamingPlayer, HeroCfg> map = Maps.newLinkedHashMap();
        //选将
        survivors.forEach(player -> {
//            final HeroCfg selected = player.requireInput(new SelectHeroOptions(getOptionHeros(player)))//
//                    .getHeroCfg();
//            player.setHero(new Hero(selected, this, player, player.getPosition()));
//            final List<HeroCfg> options = null;//todo heroOptions.get(player);
//            options.remove(selected);
//            heroCfgs.addAll(options);//没有选的武将还回武将堆。
//            map.put(player, selected);
        });
        //亮武将
        survivors.forEach(player -> player.output(map));
        game.publishEvent(new HerosShownEvent(this, map));
    }

    @Override
    public void initHand() {
        survivors.forEach(player -> {
//            final Collection<Card> cards = cardsStackPop(game.getCfg().getInitHandCardsCount());
            final HandArea hand = player.getHero().getHand();
//            if (hand.canGain(cards)) {
//                hand.gain(cards);
//            } else {
//                cardStack.gain(cards);
//            }
        });
        game.publishEvent(new InitHandEvent(game));
    }

    @Override
    public int calculateDistance(final Hero from, final Hero to) {
        return positionManager.calculateDistance(from, to);
    }

    @Override
    public List<GamingPlayer> getPlayers() {
        return players;
    }

    @Override
    public List<Team> getTeams() {
        return teams;
    }

    @Override
    public Sanguosha getGame() {
        return game;
    }

    @Override
    public List<GamingPlayer> getSurvivors() {
        return survivors;
    }

    public PositionManager getPositionManager() {
        return positionManager;
    }

    public List<IO> getIos() {
        return ios;
    }
}
