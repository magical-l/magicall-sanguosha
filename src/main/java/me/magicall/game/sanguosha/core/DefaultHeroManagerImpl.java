package me.magicall.game.sanguosha.core;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;
import me.magicall.game.sanguosha.core.gaming.Sanguosha;
import me.magicall.game.sanguosha.core.gaming.SanguoshaCfg;
import me.magicall.game.sanguosha.core.player.GamingPlayer;
import me.magicall.game.sanguosha.core.unit.HeroCfg;

import java.util.Collections;
import java.util.List;

/**
 * @author Liang Wenjian
 */
public class DefaultHeroManagerImpl implements HeroManager {

    private final Sanguosha game;

    private final SanguoshaCfg cfg;
    /**
     * 武将库。
     */
    private final List<HeroCfg> heroCfgs;

    /**
     * 武将备选记录。
     */
    private final ListMultimap<GamingPlayer, HeroCfg> heroOptions;

    public DefaultHeroManagerImpl(final Sanguosha game) {
        super();
        this.game = game;
        cfg = game.getCfg();
        heroOptions = ArrayListMultimap.create();

        final List<HeroCfg> tmp = Lists.newArrayList(cfg.getHeroCfgs());
        Collections.shuffle(tmp);
        heroCfgs = tmp;
    }

    @Override
    public List<HeroCfg> getHeroCfgs() {
        return heroCfgs;
    }

    @Override
    public List<HeroCfg> getOptionHeros(final GamingPlayer player) {
        final int size = 3;
        final List<HeroCfg> rt = Lists.newArrayListWithExpectedSize(size);
        for (int i = 0; i < size; i++) {
            final HeroCfg removed = heroCfgs.remove(i);
            rt.add(removed);
        }
        heroOptions.putAll(player, rt);
        return rt;
    }
}
