package me.magicall.game.sanguosha.core.area;

import me.magicall.game.sanguosha.core.Targetable;
import me.magicall.game.sanguosha.core.gaming.event.EventTemplate;

/**
 * @author Liang Wenjian
 */
public class RemovingCardsEvent extends EventTemplate<CardsContainer, Targetable> {

    private int count;

    public RemovingCardsEvent(final CardsContainer source, final int count) {
        super(source);
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(final int count) {
        this.count = count;
    }
}
