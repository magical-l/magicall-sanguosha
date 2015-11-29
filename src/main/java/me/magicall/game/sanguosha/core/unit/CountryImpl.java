package me.magicall.game.sanguosha.core.unit;

/**
 * 如果Countries不够用，可以用这个自定义。
 *
 * @author Liang Wenjian
 */
public class CountryImpl implements Country {

    private final String name;

    public CountryImpl(final String name) {
        super();
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
