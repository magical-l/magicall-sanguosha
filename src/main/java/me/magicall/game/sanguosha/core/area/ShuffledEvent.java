package me.magicall.game.sanguosha.core.area;

import me.magicall.game.sanguosha.core.Targetable;
import me.magicall.game.sanguosha.core.gaming.event.EventTemplate;

/**
 * @author Liang Wenjian
 */
public class ShuffledEvent extends EventTemplate<CardsContainer, Targetable> {

    public ShuffledEvent(final CardsContainer source) {
        super(source);
    }
}
