package me.magicall.game.sanguosha.core.gaming.round;

import me.magicall.game.sanguosha.core.Targetable;
import me.magicall.game.sanguosha.core.gaming.Round;
import me.magicall.game.sanguosha.core.gaming.event.EventTemplate;

/**
 * 轮次结束事件。
 *
 * @author Liang Wenjian
 */
public class RoundEndEvent extends EventTemplate<Round, Targetable> {

    public RoundEndEvent(final Round source) {
        super(source);
    }
}
