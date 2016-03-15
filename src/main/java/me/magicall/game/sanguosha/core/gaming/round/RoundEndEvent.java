package me.magicall.game.sanguosha.core.gaming.round;

import me.magicall.game.sanguosha.core.gaming.event.EventTemplate;
import me.magicall.game.sanguosha.core.gaming.Sanguosha;

/**
 * 轮次结束事件。
 *
 * @author Liang Wenjian
 */
public class RoundEndEvent extends EventTemplate<SanguoshaRound, Sanguosha> {

    public RoundEndEvent(final SanguoshaRound source) {
        super(source);
    }
}
