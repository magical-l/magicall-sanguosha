package me.magicall.game.sanguosha.core.unit;

import me.magicall.game.sanguosha.core.Targetable;
import me.magicall.mark.Named;

/**
 * 单位。
 *
 * @author Liang Wenjian
 */
public interface Unit extends Named, Targetable, HasHp {

    UnitCfg getCfg();

    @Override
    default String getName(){
        return getCfg().getName();
    }

    default double getMaxHp() {
        return getCfg().getMaxHp();
    }

    /**
     * 武将是否已受伤。
     *
     * @return
     */
    default boolean isInjured() {
        //如果角色的当前体力值小于其体力上限，称为该角色已受伤；如果角色的当前体力值等于其体力上限，称为该角色未受伤。
        return getHp().isNotFull();
    }

    /**
     * 受到伤害。
     *
     * @param value
     */
    default void injured(final double value) {
        getHp().decrease(value);
    }
}
