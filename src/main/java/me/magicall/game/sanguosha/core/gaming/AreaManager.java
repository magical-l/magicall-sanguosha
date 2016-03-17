package me.magicall.game.sanguosha.core.gaming;

import me.magicall.game.sanguosha.core.area.CardStack;
import me.magicall.game.sanguosha.core.area.Settlement;
import me.magicall.game.sanguosha.core.area.UsedCardStack;
import me.magicall.game.sanguosha.core.card.Card;

import java.util.Collection;

/**
 * @author Liang Wenjian
 */
public interface AreaManager {
    int getCardStackSize();

    Settlement getSettlement();

    UsedCardStack getUsedCardStack();

    CardStack getCardStack();

    Collection<Card> cardStackPop(int count);
}
