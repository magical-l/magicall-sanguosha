package me.magicall.game.sanguosha.core.gaming;

import me.magicall.game.sanguosha.core.player.SanguoshaPlayer;
import me.magicall.game.sanguosha.core.player.Team;

import java.util.Map;

/**
 * 记分牌。
 *
 * @author Liang Wenjian
 */
public interface Scoreboard {
    /**
     * 获取玩家的得分。
     *
     * @return
     */
    Map<SanguoshaPlayer, Double> getPlayerScores();

    /**
     * 获取团队的得分。
     *
     * @return
     */
    Map<Team, Double> getTeamScores();

    /**
     * 获取指定玩家的得分。
     *
     * @param player
     * @return
     */
    default double getScore(final SanguoshaPlayer player) {
        return getPlayerScores().get(player);
    }

    /**
     * 获取指定团队的得分。
     *
     * @param team
     * @return
     */
    default double getScore(final Team team) {
        return getTeamScores().get(team);
    }

    /**
     * 给指定玩家加分。
     *
     * @param player
     * @param delta
     */
    void increaseScore(final SanguoshaPlayer player, final double delta);

    /**
     * 给指定玩家减分。
     *
     * @param player
     * @param delta
     */
    void decreaseScore(final SanguoshaPlayer player, final double delta);
}
