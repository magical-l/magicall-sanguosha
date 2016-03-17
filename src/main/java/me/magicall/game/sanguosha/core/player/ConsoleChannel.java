package me.magicall.game.sanguosha.core.player;

import me.magicall.game.sanguosha.core.gaming.option.Options;
import me.magicall.game.sanguosha.core.gaming.option.Selection;

import java.util.Scanner;

/**
 * @author Liang Wenjian
 */
public class ConsoleChannel implements Channel {

    private final Scanner scanner = new Scanner(System.in);

    public ConsoleChannel() {
        super();
    }

    @Override
    public <T extends Selection> T requireInput(final Options<T> options) {
        System.out.println(options.getMsg());
        while (!scanner.hasNext()) {
        }
        final String input = scanner.next();
        return options.toSelection(input);
    }

    @Override
    public void output(final Object o) {
        System.out.println(o);
    }
}
