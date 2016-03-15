package me.magicall.game.sanguosha.core.gaming.event;

import me.magicall.mark.HasIdGetter.HasStrIdGetter;
import me.magicall.mark.Named;

/**
 * 事件类型。
 *
 * @author Liang Wenjian
 */
@FunctionalInterface
public interface EventType extends Named, HasStrIdGetter {
    @Override
    default String getName() {
        return getId();
    }
}
