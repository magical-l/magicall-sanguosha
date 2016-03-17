package me.magicall.game.sanguosha.core.area;

import com.google.common.collect.Lists;
import me.magicall.game.sanguosha.core.gaming.Sanguosha;

/**
 * 弃牌堆。
 *
 * @author Liang Wenjian
 */
public class UsedCardStack extends AbsCardsContainer {

    public UsedCardStack(final Sanguosha game) {
        super(game, Lists.newLinkedList());
    }
}
