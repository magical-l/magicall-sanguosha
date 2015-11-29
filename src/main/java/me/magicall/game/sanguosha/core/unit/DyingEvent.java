package me.magicall.game.sanguosha.core.unit;

import me.magicall.game.sanguosha.core.gaming.event.EventTemplate;
import me.magicall.game.sanguosha.core.gaming.Sanguosha;

/**
 * 濒死事件
 *
 * @author Liang Wenjian
 */
public class DyingEvent extends EventTemplate<Hero, Sanguosha> {

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the component that published the event (never {@code null})
     */
    public DyingEvent(final Hero source) {
        super(source);
    }
}