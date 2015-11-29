package me.magicall.game.sanguosha.core.unit;

/**
 * 血条。
 *
 * @author Liang Wenjian
 */
public interface Hp {

    double getMax();

    double getValue();

    void decrease(double value);

    default boolean isFull() {
        return getValue() >= getMax();
    }

    default boolean isNotFull() {
        return !isFull();
    }

    default double getLost() {
        return getMax() - getValue();
    }
}
