package me.magicall.game.sanguosha.core.gaming.option;

import me.magicall.game.sanguosha.core.unit.HeroCfg;

/**
 * 选择武将的结果。
 *
 * @author Liang Wenjian
 */
public class HeroSelection implements Selection {

    private final HeroCfg heroCfg;

    public HeroSelection(final HeroCfg heroCfg) {
        super();
        this.heroCfg = heroCfg;
    }

    public HeroCfg getHeroCfg() {
        return heroCfg;
    }
}
