package me.magicall.game.sanguosha.core.gaming.round;

import com.google.common.collect.Lists;
import me.magicall.game.sanguosha.core.gaming.Round;
import me.magicall.game.sanguosha.core.gaming.Sanguosha;

import java.util.List;

/**
 * 一轮。
 *
 * @author Liang Wenjian
 */
public class SanguoshaRound implements Round {

    private final Sanguosha game;
    private final int id;

    private final List<HeroTurn> heroTurns;
    private boolean finished;

    public SanguoshaRound(final Sanguosha game, final int id) {
        super();
        this.game = game;
        this.id = id;
        heroTurns = Lists.newArrayListWithExpectedSize(game.getPlayers().size());
    }

    @Override
    public void play() {
        game.publishEvent(new RoundStartEvent(this));
//        game.getSurvivors().stream().forEach(player -> {
//            final UnitTurn<?> unitTurn = new HeroTurn(this, player.getHero());
//            unitTurn.play();
//            unitTurns.add(unitTurn);
//        });
        game.publishEvent(new RoundEndEvent(this));
    }

    @Override
    public Sanguosha getGame() {
        return game;
    }

    @Override
    public List<HeroTurn> getHeroTurns() {
        return heroTurns;
    }

    @Override
    public List<HeroTurn> getRemainingHeroTurns() {
        return null;//TODO
    }

    @Override
    public HeroTurn getCurHeroTurn() {
        return null;//TODO
    }

    @Override
    public boolean isFinished() {
        return finished;
    }

    @Override
    public Integer getId() {
        return id;
    }
}
