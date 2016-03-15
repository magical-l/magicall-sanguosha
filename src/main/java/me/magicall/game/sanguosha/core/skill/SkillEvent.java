package me.magicall.game.sanguosha.core.skill;

import me.magicall.game.sanguosha.core.card.Card;
import me.magicall.game.sanguosha.core.gaming.event.EventTemplate;
import me.magicall.game.sanguosha.core.unit.Hero;

/**
 * 一个技能的一次触发事件。
 *
 * @author Liang Wenjian
 */
public class SkillEvent extends EventTemplate<Hero, Hero> {

    private Card resource;
    private Skill skill;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the component that published the event (never {@code null})
     */
    public SkillEvent(final Hero source) {
        super(source);
    }

    public Card getResource() {
        return resource;
    }

    public void setResource(final Card resource) {
        this.resource = resource;
    }

}
