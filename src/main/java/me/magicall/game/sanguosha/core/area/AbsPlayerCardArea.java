package me.magicall.game.sanguosha.core.area;

import me.magicall.game.card.Card;
import me.magicall.game.sanguosha.core.gaming.Sanguosha;
import me.magicall.game.sanguosha.core.player.Player;

import java.util.Collection;

/**
 * @author Liang Wenjian
 */
public abstract class AbsPlayerCardArea<C extends Collection<Card>> extends AbsCardsContainer<C> {

    protected final Player owner;

    public AbsPlayerCardArea(final Sanguosha game, final C cards, final Player owner) {
        super(game, cards);
        this.owner = owner;
    }

    public Player getOwner() {
        return owner;
    }

    public String toString() {
        return getOwner().getName() + '-' + super.toString();
    }
}
