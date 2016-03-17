package me.magicall.game.sanguosha.core.area;

import me.magicall.game.sanguosha.core.card.Card;

import java.util.List;

/**
 * 区域管理器。
 *
 * @author Liang Wenjian
 */
public interface AreaManager {

    int getCardStackSize();

    Settlement getSettlement();

    UsedCardStack getUsedCardStack();

    CardStack getCardStack();

    List<Card> cardStackPop(int count);
}
