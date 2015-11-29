package me.magicall.game.sanguosha.core.unit;

import me.magicall.mark.HasIdGetter.HasStrIdGetter;
import me.magicall.mark.Named;

/**
 * 势力。翻译为Country似乎好一些。
 *
 * @author Liang Wenjian
 */
@FunctionalInterface
public interface Country extends Named, HasStrIdGetter {
    /**
     * 势力id，即势力名字，等同于getName()
     *
     * @return
     */
    @Override
    default String getId() {
        return getName();
    }
}
