package me.magicall.game.sanguosha.core.gaming.round;

import me.magicall.game.sanguosha.core.gaming.event.EventTemplate;
import me.magicall.game.sanguosha.core.gaming.Sanguosha;

/**
 * 一个武将回合结束事件。
 *
 * @author Liang Wenjian
 */
public class TurnEndEvent extends EventTemplate<HeroTurn, Sanguosha> {

    public TurnEndEvent(final HeroTurn source) {
        super(source);
    }
}
