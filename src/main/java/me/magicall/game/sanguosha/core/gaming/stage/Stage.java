package me.magicall.game.sanguosha.core.gaming.stage;

import me.magicall.game.sanguosha.core.gaming.event.Event;
import me.magicall.game.sanguosha.core.gaming.Sanguosha;
import me.magicall.game.sanguosha.core.player.SanguoshaPlayer;

import java.util.List;

/**
 * 阶段。
 *
 * @author Liang Wenjian
 */
public interface Stage {

    /**
     * 主人
     *
     * @return
     */
    SanguoshaPlayer getOwner();

    Sanguosha getGame();

    List<Event<?, ?>> getEvents();

    Stage play();

    Event<?, ?> getCurEvent();
}
