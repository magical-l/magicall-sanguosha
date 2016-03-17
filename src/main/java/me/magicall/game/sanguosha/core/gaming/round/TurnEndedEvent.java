package me.magicall.game.sanguosha.core.gaming.round;

import me.magicall.game.sanguosha.core.Targetable;
import me.magicall.game.sanguosha.core.gaming.event.EventTemplate;

import java.util.List;

/**
 * @author Liang Wenjian
 */
public class TurnEndedEvent extends EventTemplate<SanguoshaRound, Targetable> {

    private final List<SanguoshaTurn> nextTurns;

    public TurnEndedEvent(final SanguoshaRound source, final List<SanguoshaTurn> nextTurns) {
        super(source);
        this.nextTurns = nextTurns;
    }

    public List<SanguoshaTurn> getNextTurns() {
        return nextTurns;
    }
}
