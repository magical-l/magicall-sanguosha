package me.magicall.game.sanguosha.core.gaming.round;

import com.google.common.collect.Lists;
import me.magicall.game.sanguosha.core.gaming.Round;
import me.magicall.game.sanguosha.core.gaming.Sanguosha;
import me.magicall.game.sanguosha.core.player.GamingPlayer;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 一轮。
 *
 * @author Liang Wenjian
 */
public class SanguoshaRound implements Round {

    private final Sanguosha game;
    private final int id;

    private final List<SanguoshaTurn> finishedTurns;

    private SanguoshaTurn curTurn;

    public SanguoshaRound(final Sanguosha game, final int id) {
        this.game = game;
        this.id = id;
        finishedTurns = Lists.newArrayListWithExpectedSize(game.getPlayerManager().getSurvivors().size());
    }

    @Override
    public RoundEndEvent play() {
        game.publishEvent(new RoundStartEvent(this));
        final List<SanguoshaTurn> nextTurns = game.getPlayerManager().getSurvivors().stream()//
                .map(player -> new SanguoshaTurnImpl(this, player.getHero()))//
                .collect(Collectors.toList());
        while (!nextTurns.isEmpty()) {
            final SanguoshaTurn turn = nextTurns.remove(0);
            final GamingPlayer player = turn.getOwner().getPlayer();
            if (!player.isDead()) {
                curTurn = new SanguoshaTurnImpl(this, player.getHero());
                curTurn.play();
                game.publishEvent(new TurnEndedEvent(this, nextTurns));
                finishedTurns.add(curTurn);
            }
        }
        curTurn = null;
        final RoundEndEvent roundEndEvent = new RoundEndEvent(this);
        game.publishEvent(roundEndEvent);
        return roundEndEvent;
    }

    @Override
    public Sanguosha getGame() {
        return game;
    }

    @Override
    public List<SanguoshaTurn> getFinishedTurns() {
        return finishedTurns;
    }

    @Override
    public SanguoshaTurn getCurTurn() {
        return curTurn;
    }

    @Override
    public Integer getId() {
        return id;
    }
}
