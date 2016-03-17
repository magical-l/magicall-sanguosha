package me.magicall.game.sanguosha.core.player;

import me.magicall.game.sanguosha.core.gaming.Sanguosha;
import me.magicall.game.sanguosha.core.gaming.Scoreboard;
import me.magicall.game.sanguosha.core.player.Team;
import me.magicall.game.sanguosha.core.player.GamingPlayer;
import me.magicall.game.sanguosha.core.unit.Hero;

import java.util.List;

/**
 * 玩家管理器
 *
 * @author Liang Wenjian
 */
public interface PlayerManager {
    Scoreboard getScoreboard();

    void initPosition();

    void selectHero();

    void initHand();

    int calculateDistance(Hero from, Hero to);

    List<GamingPlayer> getPlayers();

    List<Team> getTeams();

    Sanguosha getGame();

    List<GamingPlayer> getSurvivors();
}
