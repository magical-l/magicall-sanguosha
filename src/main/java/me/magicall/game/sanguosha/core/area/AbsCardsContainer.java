package me.magicall.game.sanguosha.core.area;

import com.google.common.collect.Lists;
import me.magicall.game.sanguosha.core.card.Card;
import me.magicall.game.sanguosha.core.gaming.Sanguosha;

import java.util.List;

/**
 * 牌区域的抽象类。
 *
 * @author Liang Wenjian
 */
public abstract class AbsCardsContainer implements CardsContainer {

    protected final String name;

    protected final Sanguosha game;
    protected final List<Card> cards;

    protected AbsCardsContainer(final Sanguosha game, final List<Card> cards) {
        name = getClass().getSimpleName();
        this.game = game;
        this.cards = cards;
    }

    public AbsCardsContainer(final String name, final Sanguosha game, final List<Card> cards) {
        this.name = name;
        this.game = game;
        this.cards = cards;
    }

    @Override
    public String getName() {
        return name;
    }

    //=================================

    @Override
    public List<Card> getCards() {
        final OpeningCardsEvent before = new OpeningCardsEvent(this, cards.size());
        game.publishEvent(before);
        final OpenCardsEvent after = new OpenCardsEvent(this, cards);
        game.publishEvent(after);
        return cards;
    }

    @Override
    public List<Card> openAtStart(final int count) {
        final OpeningCardsEvent before = new OpeningCardsEvent(this, count);
        game.publishEvent(before);
        final List<Card> cards = CardsContainer.super.openAtStart(before.getCount());
        final OpenCardsEvent event = new OpenCardsEvent(this, cards);
        game.publishEvent(event);
        return event.getTargets();
    }

    @Override
    public List<Card> removeAtStart(final int count) {
        final RemovingCardsEvent before = new RemovingCardsEvent(this, count);
        game.publishEvent(before);
        final List<Card> cards = CardsContainer.super.removeAtStart(before.getCount());
        final RemovedCardsEvent event = new RemovedCardsEvent(this, cards);
        game.publishEvent(event);
        return event.getTargets();
    }

    @Override
    public Card openFirst() {
        final OpeningCardsEvent before = new OpeningCardsEvent(this, 1);
        game.publishEvent(before);
        final Card card = CardsContainer.super.openFirst();
        final OpenCardsEvent event = new OpenCardsEvent(this, Lists.newArrayList(card));
        game.publishEvent(event);
        return event.getTargets().get(0);
    }

    @Override
    public Card removeFirst() {
        final RemovingCardsEvent before = new RemovingCardsEvent(this, 1);
        game.publishEvent(before);
        final Card card = CardsContainer.super.removeFirst();
        final OpenCardsEvent event = new OpenCardsEvent(this, Lists.newArrayList(card));
        game.publishEvent(event);
        return event.getTargets().get(0);
    }

    @Override
    public Card openRandom() {
        final OpeningCardsEvent before = new OpeningCardsEvent(this, 1);
        game.publishEvent(before);
        final Card card = CardsContainer.super.openRandom();
        final OpenCardsEvent event = new OpenCardsEvent(this, Lists.newArrayList(card));
        game.publishEvent(event);
        return event.getTargets().get(0);
    }

    @Override
    public Card removeRandom() {
        final RemovingCardsEvent before = new RemovingCardsEvent(this, 1);
        game.publishEvent(before);
        final Card card = CardsContainer.super.removeRandom();
        final RemovedCardsEvent event = new RemovedCardsEvent(this, Lists.newArrayList(card));
        game.publishEvent(event);
        return event.getTargets().get(0);
    }

    @Override
    public List<Card> openRandom(final int count) {
        final OpeningCardsEvent before = new OpeningCardsEvent(this, count);
        game.publishEvent(before);
        final List<Card> cards = CardsContainer.super.openRandom(before.getCount());
        final OpenCardsEvent after = new OpenCardsEvent(this, cards);
        game.publishEvent(after);
        return after.getTargets();
    }

    @Override
    public List<Card> removeRandom(final int count) {
        final RemovingCardsEvent before = new RemovingCardsEvent(this, count);
        game.publishEvent(before);
        final List<Card> cards = CardsContainer.super.removeRandom(before.getCount());
        final RemovedCardsEvent after = new RemovedCardsEvent(this, cards);
        game.publishEvent(after);
        return after.getTargets();
    }

    @Override
    public void putToStart(final List<Card> cards) {
        final GainingCardsEvent before = new GainingCardsEvent(this, cards, true);
        game.publishEvent(before);
        final List<Card> toUse = before.getTargets();
        CardsContainer.super.putToStart(toUse);
        final GainedCardsEvent after = new GainedCardsEvent(this, toUse, true);
        game.publishEvent(after);
    }

    @Override
    public void putToEnd(final List<Card> cards) {
        final GainingCardsEvent before = new GainingCardsEvent(this, cards, false);
        game.publishEvent(before);
        final List<Card> toUse = before.getTargets();
        CardsContainer.super.putToEnd(toUse);
        final GainedCardsEvent after = new GainedCardsEvent(this, toUse, false);
        game.publishEvent(after);
    }

    @Override
    public List<Card> shuffle() {
        final ShufflingEvent before = new ShufflingEvent(this);
        game.publishEvent(before);
        final List<Card> shuffled = CardsContainer.super.shuffle();
        final ShuffledEvent after = new ShuffledEvent(this);
        game.publishEvent(after);
        return shuffled;
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder(getName()).append(":[");
        cards.stream()//
                .forEach(e -> sb.append(e.getFlower())//
                        .append(e.getPoint())//
                        .append(e.getName())//
                        .append(','));
        return sb.append(']').toString();
    }
}
