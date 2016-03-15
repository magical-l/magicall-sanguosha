package me.magicall.game.sanguosha.core.gaming;

import me.magicall.game.sanguosha.core.player.SanguoshaPlayer;

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
    Map<SanguoshaPlayer, Double> getScores();

    /**
     * 获取指定玩家的得分。
     *
     * @param player
     * @return
     */
    default double getScore(final SanguoshaPlayer player) {
        return getScores().get(player);
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
