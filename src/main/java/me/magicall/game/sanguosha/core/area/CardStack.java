package me.magicall.game.sanguosha.core.area;

import com.google.common.collect.Lists;
import me.magicall.game.sanguosha.core.card.Card;
import me.magicall.game.sanguosha.core.gaming.Sanguosha;

import java.util.List;

/**
 * 牌堆。
 * 拿走牌堆顶的x张牌。适用于：所有摸牌、判定、五谷丰登、观星、恂恂、心战、涉猎、称象、老父魂、昭烈、裸衣等。
 *
 * @author Liang Wenjian
 */
public class CardStack extends AbsCardsContainer {

    public CardStack(final Sanguosha game) {
        super(game, Lists.newLinkedList());
    }

    public CardStack(final Sanguosha game, final List<Card> cards) {
        super(game, Lists.newLinkedList(cards));
    }

}
