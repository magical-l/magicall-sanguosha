package me.magicall.game.sanguosha.core.unit;

import me.magicall.game.sanguosha.core.gaming.event.EventTemplate;
import me.magicall.game.sanguosha.core.gaming.Sanguosha;

/**
 * 死亡事件
 *
 * @author Liang Wenjian
 */
public class DeadEvent extends EventTemplate<Hero, Sanguosha> {

    public DeadEvent(final Hero source) {
        super(source);
    }
}
