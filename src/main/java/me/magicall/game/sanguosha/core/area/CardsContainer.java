package me.magicall.game.sanguosha.core.area;

import com.google.common.collect.Lists;
import me.magicall.game.sanguosha.core.Targetable;
import me.magicall.game.sanguosha.core.card.Card;
import me.magicall.game.sanguosha.core.gaming.NoEnoughCardException;
import me.magicall.mark.Named;

import java.util.Collections;
import java.util.List;

/**
 * 牌容器。
 *
 * @author Liang Wenjian
 */
public interface CardsContainer extends Named, Targetable {

    /**
     * 获得容器内所有牌。
     *
     * @return
     */
    List<Card> getCards();

    /**
     * 查看区域内的牌的数量。
     *
     * @return
     */
    default int getCardsCount() {
        return getCards().size();
    }

    /**
     * 展开但不取走区域开头/顶部/左边的若干张牌。
     *
     * @param count
     * @return
     */
    default List<Card> openAtStart(final int count) {
        final List<Card> cards = getCards();
        if (cards.size() < count) {
            throw new NoEnoughCardException();
        }
        return cards.subList(0, count);
    }

    /**
     * 获得区域开头/顶部/左边的若干张牌，并从区域中移除之。
     *
     * @param count
     * @return
     */
    default List<Card> removeAtStart(final int count) {
        final List<Card> cards = getCards();
        if (cards.size() < count) {
            throw new NoEnoughCardException();
        }
        final List<Card> rt = Lists.newArrayList();
        for (int i = 0; i < count; i++) {
            rt.add(cards.remove(0));
        }
        return rt;
    }

    /**
     * 展开但不取走区域开头/顶部/左边的一张牌。
     *
     * @return
     */
    default Card openFirst() {
        final List<Card> cards = getCards();
        if (cards.isEmpty()) {
            throw new NoEnoughCardException();
        }
        return cards.get(0);
    }

    /**
     * 获取区域开头/顶部/左边的一张牌，并从区域中移除之。
     *
     * @return
     */
    default Card removeFirst() {
        final List<Card> cards = getCards();
        if (cards.isEmpty()) {
            throw new NoEnoughCardException();
        }
        return cards.remove(0);
    }

    /**
     * 随机展开一张牌。
     *
     * @return
     */
    default Card openRandom() {
        final List<Card> cards = getCards();
        if (cards.isEmpty()) {
            throw new NoEnoughCardException();
        }
        if (cards.size() == 1) {
            return cards.get(0);
        }
        final List<Card> tmp = Lists.newArrayList(cards);
        Collections.shuffle(tmp);
        return tmp.get(0);
    }

    default Card removeRandom() {
        final Card one = openRandom();
        getCards().remove(one);
        return one;
    }

    /**
     * 随机展开若干张牌。
     *
     * @param count
     * @return
     */
    default List<Card> openRandom(final int count) {
        final List<Card> cards = getCards();
        final int size = cards.size();
        if (size < count) {
            throw new NoEnoughCardException();
        }
        if (size == count) {
            return cards;
        }
        final List<Card> tmp = Lists.newArrayList(cards);
        Collections.shuffle(tmp);
        return tmp.subList(0, count);
    }

    default List<Card> removeRandom(final int count) {
        final List<Card> random = openRandom(count);
        getCards().removeAll(random);
        return random;
    }

    /**
     * 区域开头/顶部/左边获得牌。
     *
     * @param cards
     */
    default void putToStart(final List<Card> cards) {
        getCards().addAll(0, cards);
    }

    /**
     * 区域末尾/底部/右边获得牌。
     *
     * @param cards
     */
    default void putToEnd(final List<Card> cards) {
        getCards().addAll(cards);
    }

    /**
     * 洗牌
     */
    default List<Card> shuffle() {
        final List<Card> cards = getCards();
        Collections.shuffle(cards);
        return cards;
    }
}
