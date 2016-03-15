package me.magicall.game.sanguosha.core.gaming.position;

/**
 * 坐标。
 *
 * @author Liang Wenjian
 */
@FunctionalInterface
public interface Coordinate<THIS_TYPE extends Coordinate<THIS_TYPE, DISTANCE_TYPE>, DISTANCE_TYPE> {

    DISTANCE_TYPE distance(final THIS_TYPE other);
}
