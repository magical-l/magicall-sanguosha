package me.magicall.game.sanguosha.core.area;

import com.google.common.collect.Lists;
import me.magicall.game.card.Card;
import me.magicall.game.sanguosha.core.gaming.Sanguosha;

import java.util.Collection;
import java.util.Deque;
import java.util.List;

/**
 * 牌堆。
 *
 * @author Liang Wenjian
 */
public class CardStack extends AbsCardsContainer<Deque<Card>> {

    public CardStack(final Sanguosha game, final Collection<Card> cards) {
        super(game, Lists.newLinkedList(cards));
    }

    /**
     * 拿走牌堆顶的x张牌。
     * 适用于：所有摸牌、判定、五谷丰登、观星、恂恂、心战、涉猎、称象、老父魂、昭烈、裸衣等。
     *
     * @param count
     * @return
     */
    public List<Card> poll(final int count) {
        @SuppressWarnings("unchecked")
        final List<Card> cards = (List<Card>) getCards();
        return Lists.newArrayList(cards.subList(0, count));
    }

    /**
     * 获取但不移除牌堆顶的x张牌。
     *
     * @param count
     * @return
     */
    public List<Card> peek(final int count) {
        final Deque<Card> cards = getCards();
        final List<Card> rt = Lists.newArrayList();
        for (int i = 0; i < count; i++) {
            rt.add(cards.removeFirst());
        }
        return rt;
    }

    /**
     * 将若干牌放到牌堆顶。
     *
     * @param cards
     */
    public void putTop(final List<Card> cards) {
        @SuppressWarnings("unchecked")
        final List<Card> c = (List<Card>) getCards();
        c.addAll(0, cards);
    }

    /**
     * 将若干牌放到牌堆底。
     *
     * @param cards
     */
    public void putBottom(final List<Card> cards) {
        getCards().addAll(cards);
    }
}
