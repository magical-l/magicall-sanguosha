package me.magicall.game.sanguosha.core.gaming.round;

import me.magicall.game.sanguosha.core.gaming.event.EventTemplate;
import me.magicall.game.sanguosha.core.gaming.Sanguosha;

/**
 * 一个武将回合开始事件。
 *
 * @author Liang Wenjian
 */
public class TurnStartEvent extends EventTemplate<HeroTurn, Sanguosha> {

    public TurnStartEvent(final HeroTurn source) {
        super(source);
    }
}
