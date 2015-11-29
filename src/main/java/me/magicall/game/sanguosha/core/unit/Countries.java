package me.magicall.game.sanguosha.core.unit;

/**
 * 内置势力。
 *
 * @author Liang Wenjian
 */
public enum Countries implements Country {
    魏,
    蜀,
    吴,
    群;

    @Override
    public String getName() {
        return name();
    }
}
