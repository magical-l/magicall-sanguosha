package me.magicall.game.sanguosha.core.area;

import com.google.common.collect.Lists;
import me.magicall.game.sanguosha.core.card.Card;
import me.magicall.game.sanguosha.core.card.CardTypes;
import me.magicall.game.sanguosha.core.gaming.Sanguosha;
import me.magicall.game.sanguosha.core.player.SanguoshaPlayer;

import java.util.Collection;

/**
 * 判定区。
 *
 * @author Liang Wenjian
 */
public class JudgementArea extends AbsPlayerCardArea {

    public JudgementArea(final Sanguosha game, final SanguoshaPlayer owner) {
        super(game, Lists.newLinkedList(), owner);
    }

    public boolean canGain(final Card card) {
        //TODO:放到规则里。
        //判定区里，只能放延时锦囊，并且同名的只能贴一张。
        if (card.getType() != CardTypes.延时锦囊) {
            return false;
        }
        final Collection<Card> owning = getCards();
        for (final Card c : owning) {
            if (c.getName().equals(card.getName())) {
                return false;
            }
        }
        return true;
    }
}
