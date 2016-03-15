package me.magicall.game.sanguosha.core.gaming.event;

/**
 * @author Liang Wenjian
 */
@FunctionalInterface
public interface EventPublisher {
    void publish(final Event<?, ?> event);
}
