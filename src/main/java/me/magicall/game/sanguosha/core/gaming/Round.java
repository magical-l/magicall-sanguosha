package me.magicall.game.sanguosha.core.gaming;

import me.magicall.game.sanguosha.core.gaming.round.RoundEndEvent;
import me.magicall.game.sanguosha.core.gaming.round.SanguoshaTurn;
import me.magicall.mark.HasIdGetter.HasIntIdGetter;

import java.util.List;

/**
 * 游戏中的一轮。
 *
 * @author Liang Wenjian
 */
public interface Round extends HasIntIdGetter {

    /**
     * @return 所属游戏
     */
    Game getGame();

    /**
     * @return 已完成的回合
     */
    List<SanguoshaTurn> getFinishedTurns();

    RoundEndEvent play();

    SanguoshaTurn getCurTurn();
}
