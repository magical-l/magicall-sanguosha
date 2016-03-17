package me.magicall.game.sanguosha.embedded.界线突破;

import me.magicall.game.sanguosha.core.area.AbsCardsContainer;
import me.magicall.game.sanguosha.core.card.Card;

import java.util.Collection;

/**
 * 木牛流马牌区。
 *
 * @author Liang Wenjian
 */
public class MuniuLiumaArea extends AbsCardsContainer {
    public MuniuLiumaArea() {
        super(null,null);
//        super("木牛流马");
    }

    public boolean canGain(final Collection<Card> cards) {
        return cards.size() == 1;
    }
}
