package me.magicall.game.sanguosha.core.area;

import me.magicall.game.sanguosha.core.card.Card;
import me.magicall.game.sanguosha.core.gaming.event.EventTemplate;

import java.util.List;

/**
 * @author Liang Wenjian
 */
public class OpenCardsEvent extends EventTemplate<CardsContainer, Card> {

    public OpenCardsEvent(final CardsContainer source, final List<Card> targets) {
        super(source, targets);
    }
}
