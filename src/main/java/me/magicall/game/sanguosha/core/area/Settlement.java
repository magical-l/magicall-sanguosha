package me.magicall.game.sanguosha.core.area;

import com.google.common.collect.Lists;
import me.magicall.game.card.Card;
import me.magicall.game.sanguosha.core.gaming.Sanguosha;

import java.util.Collection;

/**
 * 结算区。
 *
 * @author Liang Wenjian
 */
public class Settlement extends AbsCardsContainer<Collection<Card>> {

    public Settlement(final Sanguosha game) {
        super(game, Lists.newLinkedList());
    }
}
