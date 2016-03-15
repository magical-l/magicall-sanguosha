package me.magicall.game.sanguosha.core.gaming.stage;

import me.magicall.game.sanguosha.core.gaming.event.EventTemplate;
import me.magicall.game.sanguosha.core.unit.Hero;

/**
 * @author Liang Wenjian
 */
public class StageStartEvent extends EventTemplate<Stage, Hero> {

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the component that published the event (never {@code null})
     */
    public StageStartEvent(final Stage source) {
        super(source);
    }
}
