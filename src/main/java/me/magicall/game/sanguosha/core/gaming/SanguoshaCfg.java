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
public class SanguoshaCfg implements GamingCfg {

    private List<Channel> channels;
    private  Collection<HeroCfg> heroCfgs;
    private  Map<CardCfg, Integer> countOfCardCfg;
    private  boolean positionFixed;
    private  Map<Role, Integer> countOfRole;
    private int initHandCardsCount;

    public SanguoshaCfg() {
        super();
    }

    @Override
    public List<Channel> getIOs() {
        return channels;
    }

    @Override
    public Collection<HeroCfg> getHeroCfgs() {
        return heroCfgs;
    }

    @Override
    public Map<CardCfg, Integer> getCountOfCardCfg() {
        return countOfCardCfg;
    }

    @Override
    public boolean isPositionFixed() {
        return positionFixed;
    }

    @Override
    public Map<Role, Integer> getCountOfRole() {
        return countOfRole;
    }

    public int getInitHandCardsCount() {
        return initHandCardsCount;
    }
}
