package me.magicall.game.sanguosha.core.rule;

import me.magicall.game.sanguosha.core.gaming.SanguoshaCfg;

/**
 * 游戏规则。
 *
 * @author Liang Wenjian
 */
@FunctionalInterface
public interface Rule {

    /**
     * 对游戏产生影响。
     *
     * @param gameCfg
     */
    void effect(final SanguoshaCfg gameCfg);
}
