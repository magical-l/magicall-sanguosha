package me.magicall.game.sanguosha.core.card;

import me.magicall.game.sanguosha.core.Targetable;
import me.magicall.game.sanguosha.core.skill.Skill;
import me.magicall.mark.Named;

import java.util.Collection;

/**
 * @author Liang Wenjian
 */
public interface Card extends Named, Targetable {

    /**
     * 判断本牌是否该类型的牌。
     *
     * @param cardType
     * @return
     */
    default boolean is(final CardType cardType) {
        return getType().is(cardType);
    }

    /**
     * 获取点数。
     *
     * @return
     */
    int getPoint();

    /**
     * 获取牌的花色。
     *
     * @return
     */
    Flower getFlower();

    /**
     * 获取牌的颜色。
     *
     * @return
     */
    default Color getColor() {
        return getFlower().getColor();
    }

    /**
     * 获取技能列表
     *
     * @return
     */
    Collection<Skill> getSkills();

    /**
     * 获取类型。
     *
     * @return
     */
    CardType getType();

}
