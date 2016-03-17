package me.magicall.game.sanguosha.core.gaming.round;

import me.magicall.game.sanguosha.core.gaming.stage.Stage;
import me.magicall.game.sanguosha.core.unit.Hero;

import java.util.List;

/**
 * @author Liang Wenjian
 */
public interface SanguoshaTurn extends UnitTurn<Hero> {

    TurnEndEvent play();

    Stage getCurStage();

    List<Stage> getFinishedStages();
}
