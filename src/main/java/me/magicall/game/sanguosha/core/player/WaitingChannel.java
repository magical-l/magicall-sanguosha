package me.magicall.game.sanguosha.core.player;

import me.magicall.game.sanguosha.core.gaming.option.Options;
import me.magicall.game.sanguosha.core.gaming.option.Selection;

/**
 * @author Liang Wenjian
 */
public class WaitingChannel implements Channel {
    public WaitingChannel() {
        super();
    }

    @Override
    public <T extends Selection> T requireInput(final Options<T> options) {
        return null;//TODO
    }

    @Override
    public void output(final Object o) {
        //TODO
    }
}
