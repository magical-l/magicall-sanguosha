package me.magicall.game.sanguosha.core.gaming.stage;

import me.magicall.game.sanguosha.core.Targetable;
import me.magicall.game.sanguosha.core.gaming.event.EventTemplate;
import me.magicall.game.sanguosha.core.gaming.round.SanguoshaTurnImpl;

import java.util.List;

/**
 * @author Liang Wenjian
 */
public class StageEndedEvent extends EventTemplate<SanguoshaTurnImpl, Targetable> {

    private final Stage curStage;
    private final List<Stage> stages;

    public StageEndedEvent(final SanguoshaTurnImpl source, final Stage curStage, final List<Stage> stages) {
        super(source);
        this.curStage = curStage;
        this.stages = stages;
    }

    public Stage getCurStage() {
        return curStage;
    }

    public List<Stage> getStages() {
        return stages;
    }
}
