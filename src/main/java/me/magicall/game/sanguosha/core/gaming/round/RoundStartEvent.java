package me.magicall.game.sanguosha.core.gaming.round;

import me.magicall.game.sanguosha.core.gaming.event.EventTemplate;
import me.magicall.game.sanguosha.core.gaming.Sanguosha;

/**
 * 回合开始事件。
 *
 * @author Liang Wenjian
 */
public class RoundStartEvent extends EventTemplate<SanguoshaRound, Sanguosha> {

    public RoundStartEvent(final SanguoshaRound source) {
        super(source);
    }
}
