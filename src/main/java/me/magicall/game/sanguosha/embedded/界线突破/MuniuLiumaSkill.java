package me.magicall.game.sanguosha.embedded.界线突破;

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
public class MuniuLiumaSkill implements Skill {

    public MuniuLiumaSkill() {
        super();
    }

    @Override
    public Effect<?> action(final Sanguosha game, final Hero user, final List<Hero> targets,
                            final Collection<Card> resources) {
        return null;//TODO
    }

    @Override
    public TargetSelector getTargetSelector() {
        return null;//TODO
    }

    @Override
    public int getMinResourcesCount() {
        return 0;//TODO
    }

    @Override
    public Integer getMaxResourcesCount() {
        return null;//TODO
    }
}
