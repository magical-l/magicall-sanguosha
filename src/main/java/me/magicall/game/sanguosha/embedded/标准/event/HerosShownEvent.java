package me.magicall.game.sanguosha.embedded.标准.event;

import me.magicall.game.sanguosha.core.gaming.event.EventTemplate;
import me.magicall.game.sanguosha.core.player.GamingPlayer;
import me.magicall.game.sanguosha.core.unit.HeroCfg;

import java.util.Map;

/**
 * @author Liang Wenjian
 */
public class HerosShownEvent extends EventTemplate {

    private static final long serialVersionUID = 5481264108819071249L;
    private final Map<GamingPlayer, HeroCfg> playerHeroMap;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the component that published the event (never {@code null})
     * @param map
     */
    public HerosShownEvent(final Object source, final Map<GamingPlayer, HeroCfg> map) {
        super(source);
        playerHeroMap = map;
    }

    public Map<GamingPlayer, HeroCfg> getPlayerHeroMap() {
        return playerHeroMap;
    }
}
