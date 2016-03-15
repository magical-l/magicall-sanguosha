package me.magicall.game.sanguosha.core.gaming.event;

import me.magicall.game.sanguosha.core.Targetable;

import java.util.Collection;
import java.util.List;

/**
 * 事件。
 *
 * @author Liang Wenjian
 */
public interface Event<S, T extends Targetable> {

    /**
     * 获取事件源。
     *
     * @return
     */
    S getSource();

    /**
     * 设置事件源。
     *
     * @param source
     */
    void setSource(final S source);

    /**
     * 获取事件的客体来源。
     *
     * @return
     */
    Object getObjectSource();

    /**
     * 设置事件的客体来源。
     *
     * @param objectSource
     */
    void setObjectSource(Object objectSource);

    /**
     * 获取目标列表。
     *
     * @return
     */
    List<T> getTargets();

    /**
     * 设置目标列表。
     *
     * @param targets
     */
    void setTargets(final List<T> targets);

    default void removeTargets(final Collection<T> target) {
        getTargets().removeAll(target);
    }

    default void addTargets(final Collection<T> targets) {
        getTargets().addAll(targets);
    }

    List<?> getSecondaryTargets();

    void setSecondaryTargets(final List<?> secondaryTargets);
}
