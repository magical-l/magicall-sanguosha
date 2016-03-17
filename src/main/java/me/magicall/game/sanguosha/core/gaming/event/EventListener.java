package me.magicall.game.sanguosha.core.gaming.event;

/**
 * @author Liang Wenjian
 */
@FunctionalInterface
public interface EventListener<E extends Event<?, ?>> {

    void on(final E event);
}
