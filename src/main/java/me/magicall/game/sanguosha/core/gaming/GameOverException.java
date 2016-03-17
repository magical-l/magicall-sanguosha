package me.magicall.game.sanguosha.core.gaming;

/**
 * 游戏结束异常。
 *
 * @author Liang Wenjian
 */
public class GameOverException extends RuntimeException {

    private static final long serialVersionUID = -4851177437455271649L;

    private Object reason;

    public GameOverException() {
        super();
    }
}
