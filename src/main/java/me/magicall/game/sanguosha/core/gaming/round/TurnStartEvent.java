package me.magicall.game.sanguosha.core.gaming.round;

import me.magicall.game.sanguosha.core.Targetable;
import me.magicall.game.sanguosha.core.gaming.event.EventTemplate;

/**
 * 一个武将回合开始事件。
 *
 * @author Liang Wenjian
 */
public class TurnStartEvent extends EventTemplate<SanguoshaTurnImpl, Targetable> {

    public TurnStartEvent(final SanguoshaTurnImpl source) {
        super(source);
    }
}
