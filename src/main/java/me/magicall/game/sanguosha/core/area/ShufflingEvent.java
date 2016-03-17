package me.magicall.game.sanguosha.core.area;

import me.magicall.game.sanguosha.core.Targetable;
import me.magicall.game.sanguosha.core.gaming.event.EventTemplate;

/**
 * @author Liang Wenjian
 */
public class ShufflingEvent extends EventTemplate<CardsContainer, Targetable> {

    public ShufflingEvent(final CardsContainer source) {
        super(source);
    }
}
