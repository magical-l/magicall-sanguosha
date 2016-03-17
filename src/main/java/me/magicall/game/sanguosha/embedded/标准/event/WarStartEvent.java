package me.magicall.game.sanguosha.embedded.标准.event;

import me.magicall.game.sanguosha.core.Targetable;
import me.magicall.game.sanguosha.core.gaming.Sanguosha;
import me.magicall.game.sanguosha.core.gaming.event.EventTemplate;

/**
 * @author Liang Wenjian
 */
public class WarStartEvent extends EventTemplate<Sanguosha, Targetable> {

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the component that published the event (never {@code null})
     */
    public WarStartEvent(final Sanguosha source) {
        super(source);
    }
}
