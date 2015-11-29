package me.magicall.game.sanguosha.core.unit;

/**
 * 性别。
 *
 * @author Liang Wenjian
 */
public enum Gender {
    男,
    女,
    无;

    /**
     * 判断武将是否本性别。
     *
     * @param hero
     * @return
     */
    public boolean isSame(final Hero hero) {
        return this == hero.getGender();
    }

    /**
     * 判断武将是否非本性别。
     *
     * @param hero
     * @return
     */
    public boolean isDifferent(final Hero hero) {
        return !isSame(hero);
    }

    /**
     * 判断二个武将性别是否相同。
     *
     * @param h1
     * @param h2
     * @return
     */
    public static boolean areSame(final Hero h1, final Hero h2) {
        return h1.getGender() == h2.getGender();
    }
}
