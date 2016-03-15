package me.magicall.game.sanguosha.core.area;

import me.magicall.game.sanguosha.core.card.Card;
import me.magicall.game.sanguosha.core.Targetable;
import me.magicall.mark.Named;

import java.util.Collection;

/**
 * 牌容器。
 *
 * @author Liang Wenjian
 */
public interface CardsContainer<C extends Collection<Card>> extends Named, Targetable {

    /**
     * 查看容器内所有牌。
     *
     * @return
     */
    C getCards();

    /**
     * 查看区域内的牌的数量。
     *
     * @return
     */
    default int getCardsCount() {
        return getCards().size();
    }

    /**
     * 区域获得牌。
     *
     * @param cards
     */
    default void gain(final Collection<Card> cards) {
        getCards().addAll(cards);
    }
}
