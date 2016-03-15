package me.magicall.game.sanguosha.embedded.标准.event;

import me.magicall.game.sanguosha.core.gaming.event.EventTemplate;
import me.magicall.game.sanguosha.core.unit.Hero;

/**
 * @author Liang Wenjian
 */
public class HarmingEvent extends EventTemplate<Hero, Hero> {

    private int count;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the component that published the event (never {@code null})
     * @param count
     */
    public HarmingEvent(final Hero source, final int count) {
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
