package me.magicall.game.sanguosha.core.gaming.round;

import me.magicall.game.sanguosha.core.unit.Unit;

/**
 * 单位的一个轮次。
 *
 * @author Liang Wenjian
 */
public interface UnitTurn<U extends Unit> {

    /**
     * 主人。
     *
     * @return
     */
    U getOwner();
}
