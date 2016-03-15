package me.magicall.game.sanguosha.core.gaming.stage;

import me.magicall.game.sanguosha.core.gaming.event.EventTemplate;
import me.magicall.game.sanguosha.core.gaming.Sanguosha;
import me.magicall.game.sanguosha.core.gaming.round.HeroTurn;

import java.util.Iterator;

/**
 * @author Liang Wenjian
 */
public class AfterStagesEvent extends EventTemplate<HeroTurn, Sanguosha> {

    private final Stage curStage;
    private Iterator<Stage> stageIterator;

    public AfterStagesEvent(final HeroTurn source, final Stage curStage, final Iterator<Stage> iterator) {
        super(source);
        this.curStage = curStage;
        stageIterator = iterator;
    }

    public Stage getCurStage() {
        return curStage;
    }

    public Iterator<Stage> getStageIterator() {
        return stageIterator;
    }
}
