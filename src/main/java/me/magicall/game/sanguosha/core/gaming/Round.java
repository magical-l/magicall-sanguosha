package me.magicall.game.sanguosha.core.gaming;

import me.magicall.game.sanguosha.core.gaming.Game;
import me.magicall.game.sanguosha.core.gaming.round.HeroTurn;
import me.magicall.mark.HasIdGetter.HasIntIdGetter;

import java.util.List;

/**
 * 游戏中的一轮。
 *
 * @author Liang Wenjian
 */
public interface Round extends HasIntIdGetter {

    void play();

    Game getGame();

    List<HeroTurn> getHeroTurns();

    List<HeroTurn> getRemainingHeroTurns();

    HeroTurn getCurHeroTurn();

    default void addHeroTurn(final HeroTurn heroTurn) {
        getHeroTurns().add(heroTurn);
    }

    /**
     * 是否已结束。
     * @return
     */
    boolean isFinished();
}
