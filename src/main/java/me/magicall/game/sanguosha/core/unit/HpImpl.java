package me.magicall.game.sanguosha.core.unit;

/**
 * @author Liang Wenjian
 */
public class HpImpl implements Hp {

    private double max;
    private double value;

    public HpImpl() {
        super();
    }

    public HpImpl(final double max) {
        this(max, max);
    }

    public HpImpl(final double max, final double value) {
        this.max = max;
        this.value = value;
    }

    @Override
    public void decrease(final double value) {
        this.value -= value;
    }

    @Override
    public double getMax() {
        return max;
    }

    public void setMax(final double max) {
        this.max = max;
    }

    @Override
    public double getValue() {
        return value;
    }

    public void setValue(final double value) {
        this.value = value;
    }
}
