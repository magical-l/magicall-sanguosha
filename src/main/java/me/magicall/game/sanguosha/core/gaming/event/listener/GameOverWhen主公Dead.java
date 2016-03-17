package me.magicall.game.sanguosha.core.gaming.event.listener;

import me.magicall.game.sanguosha.core.gaming.GameOverException;
import me.magicall.game.sanguosha.core.player.Roles;
import me.magicall.game.sanguosha.core.unit.DeadEvent;

/**
 * @author Liang Wenjian
 */
public class GameOverWhen主公Dead implements EventListener<DeadEvent> {

    public GameOverWhen主公Dead() {
        super();
    }

    @Override
    public void on(final DeadEvent event) {
        if (event.getSource().getPlayer().getRole() == Roles.主公) {
            throw new GameOverException();
        }
    }
}
