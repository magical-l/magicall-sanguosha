package me.magicall.game.sanguosha.core;

import me.magicall.game.sanguosha.core.unit.Hero;
import me.magicall.mark.Named;

/**
 * 武将状态。
 *
 * @author Liang Wenjian
 */
public interface Status extends Named {
    void whenGain(final Hero hero);
}
