package me.magicall.game.sanguosha.core.rule;

import me.magicall.game.sanguosha.core.card.Card;
import me.magicall.game.sanguosha.core.area.CardStack;

import java.util.List;

/**
 * 从牌堆获得牌的方案。
 *
 * @author Liang Wenjian
 */
@FunctionalInterface
public interface GetCardFromCardStackScheme {
    List<Card> getCards(final CardStack cardStack, final int count);
}
