package me.magicall.game.sanguosha.core.player;

import me.magicall.game.sanguosha.core.Condition.FailCondition;
import me.magicall.game.sanguosha.core.Condition.WinCondition;
import me.magicall.game.sanguosha.core.gaming.Game;
import me.magicall.game.sanguosha.core.player.GamingPlayer;
import me.magicall.mark.HasIdGetter.HasIntIdGetter;
import me.magicall.mark.Named;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * 队伍。一个队伍可能有多个玩家。
 *
 * @author Liang Wenjian
 */
public interface Team extends HasIntIdGetter, Named {

    Game getGame();

    /**
     * 获取胜利条件。
     *
     * @return
     */
    List<WinCondition> getWinConditions();

    /**
     * 获取尚未达成的胜利条件。
     *
     * @return
     */
    List<WinCondition> getRemainWinConditions();

    /**
     * 获取已达成的胜利条件。
     *
     * @return
     */
    List<WinCondition> getReachedWinConditions();

    /**
     * 达成一条胜利条件。
     *
     * @param reached
     */
    void reachWinCondition(final WinCondition reached);

    /**
     * 增加一条胜利条件。
     *
     * @param condition
     */
    void addWinCondition(final WinCondition condition);

    /**
     * 减少一条胜利条件。
     *
     * @param condition
     */
    void removeWinCondition(final WinCondition condition);

    /**
     * 获取失败条件列表。
     *
     * @return
     */
    List<FailCondition> getFailConditions();

    /**
     * 获取尚未满足的失败条件。
     *
     * @return
     */
    List<FailCondition> getRemainFailConditions();

    /**
     * 获取已满足的失败条件。
     *
     * @return
     */
    List<FailCondition> getReachedFailConditions();

    /**
     * 达成一条失败条件。
     *
     * @param reached
     */
    void reachFailCondition(final FailCondition reached);

    /**
     * 增加一条失败条件。
     *
     * @param condition
     */
    void addFailCondition(final FailCondition condition);

    /**
     * 减少一条失败条件。
     *
     * @param condition
     */
    void removeFailCondition(final FailCondition condition);

    /**
     * 获取玩家们。
     *
     * @return
     */
    Set<GamingPlayer> getPlayers();

    default boolean contains(final GamingPlayer player) {
        return getPlayers().contains(player);
    }

    /**
     * 玩家离队。
     *
     * @param players
     */
    void playersLeave(final List<GamingPlayer> players);

    /**
     * 玩家加入。
     *
     * @param players
     */
    default void playersJoinIn(final List<GamingPlayer> players){
        final Collection<GamingPlayer> members = getPlayers();
        players.forEach(e-> {
            if (!members.contains(e)) {
                members.add(e);
            }
            if (!Objects.equals(e.getTeam(), this)) {
                e.setTeam(this);
            }
        });
    }
}
