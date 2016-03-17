package me.magicall.game.sanguosha.core.gaming.event;

import me.magicall.game.sanguosha.core.Targetable;
import me.magicall.game.sanguosha.core.gaming.Sanguosha;

/**
 * 初始化游戏事件。
 *
 * @author Liang Wenjian
 */
public class InitGameEvent extends EventTemplate<Sanguosha, Targetable> {

    public InitGameEvent(final Sanguosha game) {
        super(game);
    }
}
