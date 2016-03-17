package me.magicall.game.sanguosha.core.gaming.round;

import me.magicall.game.sanguosha.core.Targetable;
import me.magicall.game.sanguosha.core.gaming.event.EventTemplate;

/**
 * 一个武将回合结束事件。
 *
 * @author Liang Wenjian
 */
public class TurnEndEvent extends EventTemplate<SanguoshaTurnImpl, Targetable> {

    public TurnEndEvent(final SanguoshaTurnImpl source) {
        super(source);
    }
}
