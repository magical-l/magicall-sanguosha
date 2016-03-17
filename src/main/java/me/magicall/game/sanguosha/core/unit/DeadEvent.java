package me.magicall.game.sanguosha.core.unit;

import me.magicall.game.sanguosha.core.Targetable;
import me.magicall.game.sanguosha.core.gaming.event.EventTemplate;

/**
 * 死亡事件
 *
 * @author Liang Wenjian
 */
public class DeadEvent extends EventTemplate<Hero, Targetable> {

    public DeadEvent(final Hero source) {
        super(source);
    }
}
