package me.magicall.game.sanguosha.core.gaming.round;

import me.magicall.game.sanguosha.core.Targetable;
import me.magicall.game.sanguosha.core.gaming.event.EventTemplate;

/**
 * 回合开始事件。
 *
 * @author Liang Wenjian
 */
public class RoundStartEvent extends EventTemplate<SanguoshaRound, Targetable> {

    public RoundStartEvent(final SanguoshaRound source) {
        super(source);
    }
}
