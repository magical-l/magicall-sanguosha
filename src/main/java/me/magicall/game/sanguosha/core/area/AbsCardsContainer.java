package me.magicall.game.sanguosha.core.area;

import me.magicall.game.sanguosha.core.card.Card;
import me.magicall.game.sanguosha.core.gaming.Sanguosha;

import java.util.Collection;

/**
 * 牌区域的抽象类。
 *
 * @author Liang Wenjian
 */
public abstract class AbsCardsContainer<C extends Collection<Card>> implements CardsContainer<C> {

    protected final String name;

    protected final Sanguosha game;
    protected final C cards;

    protected AbsCardsContainer(final Sanguosha game, final C cards) {
        this.name = getClass().getSimpleName();
        this.game = game;
        this.cards = cards;
    }

    @Override
    public C getCards() {
        return cards;
    }

    @Override
    public String getName() {
        return name;
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder(getName()).append(":[");
        cards.stream().forEach(e -> sb.append(e.getFlower()).append(e.getPoint()).append(e.getName()).append(','));
        return sb.append(']').toString();
    }
}
