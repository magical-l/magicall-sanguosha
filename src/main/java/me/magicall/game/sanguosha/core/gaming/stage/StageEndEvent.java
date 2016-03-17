package me.magicall.game.sanguosha.core.gaming.stage;

import me.magicall.game.sanguosha.core.Targetable;
import me.magicall.game.sanguosha.core.gaming.event.EventTemplate;

/**
 * @author Liang Wenjian
 */
public class StageEndEvent extends EventTemplate<Stage, Targetable> {

    public StageEndEvent(final Stage source) {
        super(source);
    }

}
