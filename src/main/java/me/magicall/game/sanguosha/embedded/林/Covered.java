package me.magicall.game.sanguosha.embedded.林;

import me.magicall.game.sanguosha.core.unit.Status;
import me.magicall.game.sanguosha.core.unit.Hero;

/**
 * @author Liang Wenjian
 */
public class Covered implements Status {

    public Covered() {
        super();
    }

    @Override
    public String getName() {
        return "翻面";
    }

    @Override
    public void whenGain(final Hero hero) {
        //TODO：给回合管理器+监听器，轮到此武将时，去除本状态和该监听器，然后跳过该武将回合。
    }
}
