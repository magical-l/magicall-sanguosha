package me.magicall.game.sanguosha.core.player;

import me.magicall.game.sanguosha.core.gaming.option.Options;
import me.magicall.game.sanguosha.core.gaming.option.Selection;

/**
 * 玩家的io通道。屏蔽与玩家进行交互的底层通道
 *
 * @author Liang Wenjian
 */
public interface Channel {

    <T extends Selection> T requireInput(final Options<T> options);

    void output(Object o);
}
