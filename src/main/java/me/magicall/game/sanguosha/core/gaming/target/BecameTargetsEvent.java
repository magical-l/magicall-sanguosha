package me.magicall.game.sanguosha.core.gaming.target;

import me.magicall.game.sanguosha.core.gaming.event.EventTemplate;
import me.magicall.game.sanguosha.core.skill.Skill;
import me.magicall.game.sanguosha.core.unit.Hero;

import java.util.Collection;

/**
 * @author Liang Wenjian
 */
public class BecameTargetsEvent extends EventTemplate<Collection<Hero>, Skill> {

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the component that published the event (never {@code null})
     */
    public BecameTargetsEvent(final Collection<Hero> source, final Skill skill) {
        super(source, skill);
    }

}
