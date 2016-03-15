package me.magicall.game.sanguosha.embedded.标准.event;

import me.magicall.game.sanguosha.core.card.Card;
import me.magicall.game.sanguosha.core.gaming.event.EventTemplate;

import java.util.List;

/**
 * @author Liang Wenjian
 */
public class GetUsableCardsEvent extends EventTemplate<Object, Card> {

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the component that published the event (never {@code null})
     * @param cards
     */
    public GetUsableCardsEvent(final Object source, final List<Card> cards) {
        super(source, cards);
    }
}
