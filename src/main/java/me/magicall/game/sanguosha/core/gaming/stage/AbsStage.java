package me.magicall.game.sanguosha.core.gaming.stage;

import com.google.common.collect.Lists;
import me.magicall.game.sanguosha.core.gaming.event.Event;
import me.magicall.game.sanguosha.core.gaming.Sanguosha;
import me.magicall.game.sanguosha.core.player.SanguoshaPlayer;

import java.util.List;

/**
 * @author Liang Wenjian
 */
public abstract class AbsStage implements Stage {

    private final Sanguosha game;
    private final SanguoshaPlayer owner;

    private final List<Event<?, ?>> events = Lists.newArrayList();

    public AbsStage(final Sanguosha game, final SanguoshaPlayer owner) {
        super();
        this.game = game;
        this.owner = owner;
    }

    @Override
    public void play() {
        final Sanguosha game = getGame();
        game.publishEvent(new StageStartEvent(this));

        playInternal();

        game.publishEvent(new StageEndEvent(this));
    }

    protected abstract void playInternal();

    @Override
    public SanguoshaPlayer getOwner() {
        return owner;
    }

    @Override
    public Sanguosha getGame() {
        return game;
    }

    @Override
    public List<Event<?, ?>> getEvents() {
        return events;
    }
}
