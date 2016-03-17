package me.magicall.game.sanguosha.core.player;

import me.magicall.game.sanguosha.core.gaming.CalculateDistanceEvent;
import me.magicall.game.sanguosha.core.gaming.Sanguosha;
import me.magicall.game.sanguosha.core.gaming.position.Position;
import me.magicall.game.sanguosha.core.player.GamingPlayer;
import me.magicall.game.sanguosha.core.unit.Hero;

import java.util.Map;

/**
 * @author Liang Wenjian
 */
public class PositionManager {

    private Map<Position,GamingPlayer> positionPlayer;

    public PositionManager() {
        super();
    }
    public int calculateDistance(final Hero from, final Hero to) {
        final Sanguosha game = from.getGame();
        final CalculateDistanceEvent event = new CalculateDistanceEvent(game, from);
        game.publishEvent(event);

        final int distance = 0;// from.getCoordinate().distance(to.getCoordinate());

        return distance;//TODO:没算死人呢。
    }

}
