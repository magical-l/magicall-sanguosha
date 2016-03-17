package me.magicall.game.sanguosha.core;

import com.google.common.collect.Lists;
import me.magicall.game.sanguosha.core.gaming.Round;
import me.magicall.game.sanguosha.core.gaming.RoundManager;
import me.magicall.game.sanguosha.core.gaming.Sanguosha;
import me.magicall.game.sanguosha.core.gaming.round.RoundEndEvent;
import me.magicall.game.sanguosha.core.gaming.round.SanguoshaRound;

import java.util.List;

/**
 * @author Liang Wenjian
 */
public class DefaultRoundManager implements RoundManager {

    private final Sanguosha game;
    /**
     * 轮次。
     */
    private final List<Round> rounds = Lists.newArrayList();
    /**
     * 当前轮次
     */
    private SanguoshaRound curRound;

    public DefaultRoundManager(final Sanguosha game) {
        this.game = game;
    }

    @Override
    public RoundEndEvent roundPlay() {
        curRound = new SanguoshaRound(game, getFinishedRoundCount() + 1);
        final RoundEndEvent roundEndEvent = curRound.play();
        rounds.add(curRound);
        return roundEndEvent;
    }

    public Sanguosha getGame() {
        return game;
    }

    @Override
    public List<Round> getFinishedRounds() {
        return rounds;
    }

    @Override
    public Round getCurRound() {
        return curRound;
    }
}
