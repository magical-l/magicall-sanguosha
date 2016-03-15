package me.magicall.game.sanguosha.embedded.标准.event;

import me.magicall.game.sanguosha.core.card.Card;
import me.magicall.game.sanguosha.core.gaming.event.EventTemplate;
import me.magicall.game.sanguosha.core.unit.Hero;

import java.util.List;

/**
 * @author Liang Wenjian
 */
public class Event_打出牌 extends EventTemplate<Hero, Card> {

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the component that published the event (never {@code null})
     */
    public Event_打出牌(final Hero source, final List<Card> cards) {
        super(source, cards);
    }

}
