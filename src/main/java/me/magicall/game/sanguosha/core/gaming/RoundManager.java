package me.magicall.game.sanguosha.core.gaming;

import me.magicall.game.sanguosha.core.gaming.round.RoundEndEvent;
import me.magicall.game.sanguosha.core.gaming.round.SanguoshaTurn;

import java.util.List;

/**
 * @author Liang Wenjian
 */
public interface RoundManager {

    /**
     * 进行一个轮次。
     *
     * @return
     */
    RoundEndEvent roundPlay();

    /**
     * 获取已进行的轮次总数（当前轮次不算）
     *
     * @return
     */
    default int getFinishedRoundCount() {
        return getFinishedRounds().size();
    }

    List<Round> getFinishedRounds();

    /**
     * 获取当前轮次。
     *
     * @return
     */
    Round getCurRound();

    /**
     * 获取当前回合
     * @return
     */
    default SanguoshaTurn getCurTurn() {
        return getCurRound().getCurTurn();
    }
}
