package me.magicall.game.sanguosha.core.gaming.stage;

import me.magicall.game.sanguosha.core.gaming.event.EventTemplate;
import me.magicall.game.sanguosha.core.gaming.Sanguosha;

/**
 * @author Liang Wenjian
 */
public class StageEndEvent extends EventTemplate<Stage, Sanguosha> {

    public StageEndEvent(final Stage source) {
        super(source);
    }

}
