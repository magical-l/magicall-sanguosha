package me.magicall.game.sanguosha.embedded.标准.event;

import me.magicall.game.sanguosha.core.gaming.event.EventTemplate;
import me.magicall.game.sanguosha.core.skill.Skill;

import java.util.List;

/**
 * @author Liang Wenjian
 */
public class GetUsableSkillsEvent extends EventTemplate<Object, Skill> {

    public GetUsableSkillsEvent(final Object source, final List<Skill> skills) {
        super(source, skills);
    }

}
