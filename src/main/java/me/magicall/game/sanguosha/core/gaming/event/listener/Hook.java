package me.magicall.game.sanguosha.core.gaming.event.listener;

import me.magicall.game.sanguosha.core.gaming.event.Event;

/**
 * @author Liang Wenjian
 */
public interface Hook<E extends Event<?, ?>> {

    Class<E> getEventClass();

    default boolean supports(final Event<?, ?> event) {
        return getEventClass().isAssignableFrom(event.getClass());
    }

    void before(E event);

    void after(E event);
}
