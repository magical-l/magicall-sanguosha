package me.magicall.game.sanguosha.core.skill;

import me.magicall.game.sanguosha.core.Targetable;
import me.magicall.game.sanguosha.core.card.Card;
import me.magicall.game.sanguosha.core.gaming.Sanguosha;
import me.magicall.game.sanguosha.core.gaming.target.TargetSelector;
import me.magicall.game.sanguosha.core.unit.Hero;
import me.magicall.mark.Named;

import java.util.Collection;
import java.util.List;

/**
 * 技能。
 *
 * @author Liang Wenjian
 */
public interface Skill extends Named, Targetable {

    @Override
    default String getName() {
        return getClass().getSimpleName();
    }

    default void init(final Sanguosha game, final Hero owner) {
    }

    Effect<?> action(Sanguosha game, Hero hero, List<Hero> targets, Collection<Card> resources);

    TargetSelector getTargetSelector();

    default int getMinResourcesCount() {
        return 1;
    }

    default Integer getMaxResourcesCount() {
        return 1;
    }

    default boolean is主公技() {
        return false;
    }

    default boolean is锁定技() {
        return false;
    }
}
