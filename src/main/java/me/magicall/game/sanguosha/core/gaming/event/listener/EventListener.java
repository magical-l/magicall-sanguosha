package me.magicall.game.sanguosha.core.gaming.event.listener;

import me.magicall.game.sanguosha.core.gaming.event.Event;

/**
 * @author Liang Wenjian
 */
@FunctionalInterface
public interface EventListener<E extends Event<?, ?>> {

    void on(final E event);
}
