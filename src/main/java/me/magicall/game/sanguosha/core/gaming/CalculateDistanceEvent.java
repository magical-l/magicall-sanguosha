package me.magicall.game.sanguosha.core.gaming;

import me.magicall.game.sanguosha.core.gaming.event.EventTemplate;
import me.magicall.game.sanguosha.core.unit.Hero;

/**
 * @author Liang Wenjian
 */
public class CalculateDistanceEvent extends EventTemplate<Sanguosha, Hero> {

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the component that published the event (never {@code null})
     */
    public CalculateDistanceEvent(final Sanguosha source, final Hero hero) {
        super(source, hero);
    }

}
