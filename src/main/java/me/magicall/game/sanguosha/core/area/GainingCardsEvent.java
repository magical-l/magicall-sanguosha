package me.magicall.game.sanguosha.core.area;

import me.magicall.game.sanguosha.core.card.Card;
import me.magicall.game.sanguosha.core.gaming.event.EventTemplate;

import java.util.List;

/**
 * @author Liang Wenjian
 */
public class GainingCardsEvent extends EventTemplate<CardsContainer, Card> {

    private final boolean atStart;

    public GainingCardsEvent(final CardsContainer source, final List<Card> targets, final boolean atStart) {
        super(source, targets);
        this.atStart = atStart;
    }

    public boolean isAtStart() {
        return atStart;
    }
}
