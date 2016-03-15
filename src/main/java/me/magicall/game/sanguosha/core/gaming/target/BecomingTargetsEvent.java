package me.magicall.game.sanguosha.core.gaming.target;

import me.magicall.game.sanguosha.core.gaming.event.EventTemplate;
import me.magicall.game.sanguosha.core.skill.Skill;
import me.magicall.game.sanguosha.core.unit.Hero;

import java.util.List;

/**
 * @author Liang Wenjian
 */
public class BecomingTargetsEvent extends EventTemplate<List<Hero>, Skill> {

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the component that published the event (never {@code null})
     */
    public BecomingTargetsEvent(final List<Hero> source, final Skill skill) {
        super(source, skill);
    }

}
