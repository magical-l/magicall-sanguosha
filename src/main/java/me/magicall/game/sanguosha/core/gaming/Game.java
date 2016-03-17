package me.magicall.game.sanguosha.core.gaming;

import me.magicall.game.sanguosha.core.player.GamingPlayer;
import me.magicall.game.sanguosha.core.player.Team;

import java.util.List;

/**
 * 游戏
 *
 * @author Liang Wenjian
 */
public interface Game {

    /**
     * 游戏开始。
     */
    Scoreboard start();

    /**
     * 获取玩家。
     *
     * @return
     */
    List<GamingPlayer> getPlayers();

    /**
     * 获取队伍
     * @return
     */
    List<Team> getTeams();
}
