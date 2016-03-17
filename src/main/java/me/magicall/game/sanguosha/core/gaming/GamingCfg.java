package me.magicall.game.sanguosha.core.gaming;

import me.magicall.game.sanguosha.core.card.CardCfg;
import me.magicall.game.sanguosha.core.player.Channel;
import me.magicall.game.sanguosha.core.player.Role;
import me.magicall.game.sanguosha.core.unit.HeroCfg;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author Liang Wenjian
 */
public interface GamingCfg {

    List<Channel> getIOs();

    Collection<HeroCfg> getHeroCfgs();

    Map<CardCfg, Integer> getCountOfCardCfg();

    boolean isPositionFixed();

    Map<Role, Integer> getCountOfRole();
}
