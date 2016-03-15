package me.magicall.game.sanguosha.core;

import me.magicall.game.sanguosha.core.gaming.Game;

import java.util.function.Predicate;

/**
 * 胜利条件/失败条件
 *
 * @author Liang Wenjian
 */
@FunctionalInterface
public interface Condition extends Predicate<Game> {

    @FunctionalInterface
    interface WinCondition extends Condition {

    }

    @FunctionalInterface
    interface FailCondition extends Condition {

    }
}
