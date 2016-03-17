package me.magicall.game.sanguosha.embedded.标准.event;

import me.magicall.game.sanguosha.core.Targetable;
import me.magicall.game.sanguosha.core.gaming.Sanguosha;
import me.magicall.game.sanguosha.core.gaming.event.EventTemplate;

/**
 * @author Liang Wenjian
 */
public class WarEndEvent extends EventTemplate<Sanguosha, Targetable> {

    private static final long serialVersionUID = -5204914756415267698L;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the component that published the event (never {@code null})
     */
    public WarEndEvent(final Sanguosha source) {
        super(source);
    }
}
