package me.magicall.game.sanguosha.core.area;

import com.google.common.collect.Lists;
import me.magicall.game.sanguosha.core.card.Card;
import me.magicall.game.sanguosha.core.gaming.Sanguosha;
import me.magicall.game.sanguosha.core.player.SanguoshaPlayer;

import java.util.List;
import java.util.Random;

/**
 * 手牌区。
 *
 * @author Liang Wenjian
 */
public class HandArea extends AbsPlayerCardArea<List<Card>> {

    private static final Random RANDOM = new Random();

    public HandArea(final Sanguosha game, final SanguoshaPlayer owner) {
        super(game, Lists.newArrayList(), owner);
    }

    /**
     * 随机失去若干张牌。
     * 适用于过拆、顺手、突袭、陷嗣等。
     *
     * @param count
     */
    public List<Card> discard(final int count) {
        final List<Card> cards = getCards();
        final List<Card> rt = Lists.newArrayList();
        if (count > cards.size()) {
            rt.addAll(cards);
            cards.clear();
        } else {
            for (int i = 0; i < count; i++) {
                rt.add(cards.remove(RANDOM.nextInt(cards.size())));
            }
        }
        return rt;
    }
}
