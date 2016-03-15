package me.magicall.game.sanguosha.core.rule;

/**
 * 摸牌数量方案。
 *
 * @author Liang Wenjian
 */
@FunctionalInterface
public interface GetCardCountFromCardStackScheme {
    int getCount();
}
