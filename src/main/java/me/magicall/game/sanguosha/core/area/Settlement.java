package me.magicall.game.sanguosha.core.area;

import com.google.common.collect.Lists;
import me.magicall.game.sanguosha.core.gaming.Sanguosha;

/**
 * 结算区。
 *
 * @author Liang Wenjian
 */
public class Settlement extends AbsCardsContainer {

    public Settlement(final Sanguosha game) {
        super(game, Lists.newLinkedList());
    }
}
