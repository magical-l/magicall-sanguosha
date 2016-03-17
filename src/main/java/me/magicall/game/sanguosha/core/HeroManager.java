package me.magicall.game.sanguosha.core;

import me.magicall.game.sanguosha.core.player.GamingPlayer;
import me.magicall.game.sanguosha.core.unit.HeroCfg;

import java.util.List;

/**
 * 武将管理器
 *
 * @author Liang Wenjian
 */
public interface HeroManager {
    List<HeroCfg> getHeroCfgs();

    List<HeroCfg> getOptionHeros(GamingPlayer player);
}
