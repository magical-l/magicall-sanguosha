package me.magicall.game.sanguosha.core.gaming.stage;

import me.magicall.game.sanguosha.core.area.HandArea;
import me.magicall.game.sanguosha.core.gaming.Sanguosha;
import me.magicall.game.sanguosha.core.player.GamingPlayer;
import me.magicall.game.sanguosha.core.unit.Hero;

/**
 * 弃牌阶段。
 * 弃牌阶段：检查角色的手牌数是否超出角色的手牌上限，若超出须弃置一张手牌。如此反复，直到检查其手牌数等于其手牌上限为止。
 *
 * @author Liang Wenjian
 */
public class DiscardStage extends AbsStage {

    public DiscardStage(final Sanguosha game, final Hero hero) {
        super(game, hero.getPlayer());
    }

    @Override
    protected void playInternal() {
        final GamingPlayer owner = (GamingPlayer) getOwner();
        final int defaultRemainCount = 0;//owner.getHp();

        final Sanguosha game = getGame();
        final CalculateDiscardCountEvent event = new CalculateDiscardCountEvent(this, defaultRemainCount);
        game.publishEvent(event);
        final int remainCount = event.getAvailableRemainCount();

        final HandArea hand = owner.getHand();
//        for (int count = hand.getCardsCount() - remainCount; count > 0; count = hand.getCardsCount() - remainCount) {
//            owner.requireInput(new DiscardOptions(null, count))//TODO
//                    .getCardIds().stream()//
//                    .forEach(e -> hand.loss(Collections.singleton(game.getCard(e))));
//        }
    }
}
