package me.magicall.game.sanguosha.core.player;

/**
 * 身份。
 *
 * @author Liang Wenjian
 */
public enum Roles implements Role {
    主公,
    忠臣,
    反贼,
    内奸;

    @Override
    public String getName() {
        return name();
    }
}
