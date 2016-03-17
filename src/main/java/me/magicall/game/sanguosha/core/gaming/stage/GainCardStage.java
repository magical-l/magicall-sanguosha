package me.magicall.game.sanguosha.core.gaming.stage;

import me.magicall.game.sanguosha.core.card.Card;
import me.magicall.game.sanguosha.core.area.CardsContainer;
import me.magicall.game.sanguosha.core.gaming.Sanguosha;
import me.magicall.game.sanguosha.core.player.GamingPlayer;
import me.magicall.game.sanguosha.core.unit.Hero;

import java.util.Collection;

/**
 * 摸牌阶段。
 * 摸牌阶段：角色摸两张牌。
 *
 * @author Liang Wenjian
 */
public class GainCardStage extends AbsStage {

    private static final int GAIN_COUNT = 2;

    public GainCardStage(final Sanguosha game, final Hero hero) {
        super(game, hero.getPlayer());
    }

    @Override
    protected void playInternal() {
        final Collection<Card> cards = getGame().cardsStackPop(GAIN_COUNT);
        final CardsContainer hand = ((GamingPlayer)getOwner()).getHand();
//        if (hand.canGain(cards)) {
//            hand.gain(cards);
//        }
    }
}
