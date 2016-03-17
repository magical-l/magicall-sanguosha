package me.magicall.game.sanguosha.core.card;

import me.magicall.game.sanguosha.core.card.Card;

/**
 * 卡牌管理器
 *
 * @author Liang Wenjian
 */
public interface CardManager {

    void initCardStack();

    Card getCard(Integer cardId);
}
