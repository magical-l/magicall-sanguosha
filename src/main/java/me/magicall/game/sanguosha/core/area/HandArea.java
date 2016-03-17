package me.magicall.game.sanguosha.core.area;

import com.google.common.collect.Lists;
import me.magicall.game.sanguosha.core.gaming.Sanguosha;
import me.magicall.game.sanguosha.core.player.SanguoshaPlayer;

/**
 * 手牌区。
 * 随机失去若干张牌。适用于过拆、顺手、突袭、陷嗣等。
 *
 * @author Liang Wenjian
 */
public class HandArea extends AbsPlayerCardArea {

    public HandArea(final Sanguosha game, final SanguoshaPlayer owner) {
        super(game, Lists.newArrayList(), owner);
    }
}
