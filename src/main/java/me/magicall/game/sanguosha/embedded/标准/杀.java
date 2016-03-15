package me.magicall.game.sanguosha.embedded.标准;

import me.magicall.game.sanguosha.core.card.CardCfg;
import me.magicall.game.sanguosha.core.card.CardType;
import me.magicall.game.sanguosha.core.card.Flower;

/**
 * @author Liang Wenjian
 */
public class 杀 extends CardCfg {
    public 杀(final CardType type, final int point, final Flower flower) {
        super(type, point, flower, new Skill_杀());
    }

}
