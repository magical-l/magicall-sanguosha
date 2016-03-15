package me.magicall.game.sanguosha.embedded.标准.event;

import me.magicall.game.sanguosha.core.gaming.event.EventTemplate;
import me.magicall.game.sanguosha.core.unit.Hero;

/**
 * @author Liang Wenjian
 */
public class HarmedEvent extends EventTemplate<Hero, Hero> {

    private int point;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the component that published the event (never {@code null})
     */
    public HarmedEvent(final Hero source) {
        super(source);
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
