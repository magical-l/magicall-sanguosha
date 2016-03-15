package me.magicall.game.sanguosha.embedded.标准.event;

import me.magicall.game.sanguosha.core.gaming.event.EventTemplate;
import me.magicall.game.sanguosha.core.area.CardsContainer;

import java.util.List;

/**
 * @author Liang Wenjian
 */
public class GetUsableAreasEvent extends EventTemplate<Object, CardsContainer> {

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the component that published the event (never {@code null})
     * @param cardsContainers
     */
    public GetUsableAreasEvent(final Object source, final List<CardsContainer> cardsContainers) {
        super(source, cardsContainers);
    }
}
