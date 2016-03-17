package me.magicall.game.sanguosha.core.area;

import com.google.common.collect.Lists;
import me.magicall.game.sanguosha.core.card.Card;
import me.magicall.game.sanguosha.core.gaming.Sanguosha;

import java.util.Collections;
import java.util.List;

/**
 * @author Liang Wenjian
 */
public class DefaultAreaManagerImpl implements AreaManager {

    private Sanguosha game;

    private final CardStack cardStack;
    /**
     * 结算区。
     */
    private final Settlement settlement;
    /**
     * 弃牌堆。
     */
    private final UsedCardStack usedCardStack;

    public DefaultAreaManagerImpl(final Sanguosha game) {
        this.game = game;
        settlement = new Settlement(game);
        usedCardStack = new UsedCardStack(game);
        cardStack = new CardStack(game);
    }

    @Override
    public int getCardStackSize() {
        return cardStack.getCards().size();
    }

    @Override
    public Settlement getSettlement() {
        return null;//TODO
    }

    @Override
    public UsedCardStack getUsedCardStack() {
        return null;//TODO
    }

    @Override
    public CardStack getCardStack() {
        return null;//TODO
    }

    @Override
    public List<Card> cardStackPop(final int count) {
        if (cardStack.getCardsCount() < count) {
            //牌堆不够就洗牌
            final List<Card> cards = Lists.newArrayList(usedCardStack.getCards());
//            usedCardStack.loss(cards);
            Collections.shuffle(cards);
            cardStack.putToEnd(cards);
            //洗牌后依然不够
            if (cardStack.getCardsCount() < count) {
                throw new NoEnoughCardException();
            }
        }
        return cardStack.removeAtStart(count);
    }
}
