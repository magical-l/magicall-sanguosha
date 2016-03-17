package me.magicall.game.sanguosha.core.gaming.round;

import com.google.common.collect.Lists;
import me.magicall.game.sanguosha.core.gaming.Sanguosha;
import me.magicall.game.sanguosha.core.gaming.stage.StageEndedEvent;
import me.magicall.game.sanguosha.core.gaming.stage.DiscardStage;
import me.magicall.game.sanguosha.core.gaming.stage.EndStage;
import me.magicall.game.sanguosha.core.gaming.stage.GainCardStage;
import me.magicall.game.sanguosha.core.gaming.stage.JudgementStage;
import me.magicall.game.sanguosha.core.gaming.stage.PlayerPlayStage;
import me.magicall.game.sanguosha.core.gaming.stage.PrepareStage;
import me.magicall.game.sanguosha.core.gaming.stage.Stage;
import me.magicall.game.sanguosha.core.unit.Hero;

import java.util.List;

/**
 * 一个武将的一个回合。
 *
 * @author Liang Wenjian
 */
public class SanguoshaTurnImpl implements UnitTurn<Hero>, SanguoshaTurn {

    private final SanguoshaRound round;
    private final Hero owner;
    private final List<Stage> finishedStages;
    private Stage curStage;

    public SanguoshaTurnImpl(final SanguoshaRound round, final Hero owner) {
        super();
        this.round = round;
        this.owner = owner;
        finishedStages = Lists.newArrayList();
    }

    @Override
    public TurnEndEvent play() {
        final Sanguosha game = getGame();
        final List<Stage> stages = Lists.newArrayList(//todo:这个初始化做到rule监听器去
                new PrepareStage(game, owner),//
                new JudgementStage(game, owner),//
                new GainCardStage(game, owner),//
                new PlayerPlayStage(game, owner),//
                new DiscardStage(game, owner),//
                new EndStage(game, owner));
        game.publishEvent(new TurnStartEvent(this));
        while (!stages.isEmpty()) {
            curStage = stages.remove(0);
            curStage.play();
            game.publishEvent(new StageEndedEvent(this, curStage, stages));
            finishedStages.add(curStage);
        }
        curStage = null;
        final TurnEndEvent turnEndEvent = new TurnEndEvent(this);
        game.publishEvent(turnEndEvent);
        return turnEndEvent;
    }

    @Override
    public Hero getOwner() {
        return owner;
    }

    public Sanguosha getGame() {
        return round.getGame();
    }

    public SanguoshaRound getRound() {
        return round;
    }

    @Override
    public List<Stage> getFinishedStages() {
        return finishedStages;
    }

    @Override
    public Stage getCurStage() {
        return curStage;
    }
}
