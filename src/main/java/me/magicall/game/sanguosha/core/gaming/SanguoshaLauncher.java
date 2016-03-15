package me.magicall.game.sanguosha.core.gaming;

import me.magicall.game.sanguosha.core.card.Card;
import me.magicall.game.sanguosha.core.card.CardCfg;
import me.magicall.game.sanguosha.core.player.IO;
import me.magicall.game.sanguosha.core.player.Role;
import me.magicall.game.sanguosha.core.rule.Rule;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 游戏运行器。
 *
 * @author Liang Wenjian
 */
public class SanguoshaLauncher {

    private final List<IO> players;
    private final Collection<Rule> rules;

    public SanguoshaLauncher(final List<IO> players, final Collection<Rule> rules) {
        super();
        this.players = players;
        this.rules = rules;
    }

    public void launch() {
        //校验参数
        if (players == null || players.isEmpty()) {
            throw new RuntimeException();
        }
        if (rules == null || rules.isEmpty()) {
            throw new RuntimeException();
        }

        //初始化事件管理器

        final SanguoshaCfg gameCfg = new SanguoshaCfg();
        //初始化规则集
        rules.stream().forEach(r -> r.effect(gameCfg));

        //初始化身份
        final Map<Role, Integer> rolesCfg = gameCfg.getCountOfRole();
        final Map<IO, Role> roleMapping = initRoleMapping(players, rolesCfg);
        //初始化存活者
        //初始化桌子
        final Map<CardCfg, Integer> countOfCardCfg = gameCfg.getCountOfCardCfg();
        List<Card> cards = initCardStack(countOfCardCfg);
        //初始化轮次
        //初始化武将堆
        //选将
        //初始化技能
        //分发初始手牌
        final Sanguosha game = new Sanguosha(gameCfg);
        game.start();
    }

    private List<Card> initCardStack(Map<CardCfg, Integer> countOfCardCfg) {
        return null;//TODO
    }

    private Map<IO, Role> initRoleMapping(List<IO> players, Map<Role, Integer> rolesCfg) {
        return null;//TODO
    }
}
