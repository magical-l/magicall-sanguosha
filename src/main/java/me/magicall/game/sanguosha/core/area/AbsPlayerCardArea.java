package me.magicall.game.sanguosha.core.area;

import me.magicall.game.sanguosha.core.card.Card;
import me.magicall.game.sanguosha.core.gaming.Sanguosha;
import me.magicall.game.sanguosha.core.player.SanguoshaPlayer;

import java.util.List;

/**
 * @author Liang Wenjian
 */
public abstract class AbsPlayerCardArea extends AbsCardsContainer {

    protected final SanguoshaPlayer owner;

    public AbsPlayerCardArea(final Sanguosha game, final List<Card> cards, final SanguoshaPlayer owner) {
        super(game, cards);
        this.owner = owner;
    }

    public SanguoshaPlayer getOwner() {
        return owner;
    }

    public String toString() {
        return getOwner().getName() + '-' + super.toString();
    }
}
