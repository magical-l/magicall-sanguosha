package me.magicall.game.sanguosha.embedded.标准;

import me.magicall.game.sanguosha.core.card.Card;
import me.magicall.game.sanguosha.core.gaming.Sanguosha;
import me.magicall.game.sanguosha.core.gaming.target.TargetSelector;
import me.magicall.game.sanguosha.core.skill.Effect;
import me.magicall.game.sanguosha.core.skill.Skill;
import me.magicall.game.sanguosha.core.unit.Hero;

import java.util.Collection;
import java.util.List;

/**
 * @author Liang Wenjian
 */
class Skill_杀 implements Skill {

    @Override
    public Effect<?> action(final Sanguosha game, final Hero hero, final List<Hero> targets,
                            final Collection<Card> resources) {

        return null;//TODO
    }

    @Override
    public TargetSelector getTargetSelector() {
        return null;//TODO
    }
}
