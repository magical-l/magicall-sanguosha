package me.magicall.game.sanguosha.core.player;

import me.magicall.game.sanguosha.core.area.EquipArea;
import me.magicall.game.sanguosha.core.area.HandArea;
import me.magicall.game.sanguosha.core.area.JudgementArea;
import me.magicall.game.sanguosha.core.gaming.Sanguosha;
import me.magicall.game.sanguosha.core.gaming.position.Position;
import me.magicall.game.sanguosha.core.unit.Hero;
import me.magicall.mark.Named;

/**
 * 参与游戏的玩家。
 *
 * @author Liang Wenjian
 */
public interface SanguoshaPlayer extends IO, Named {

    /**
     * 获取当前游戏。
     *
     * @return
     */
    Sanguosha getGame();

    /**
     * 获取所属队伍。
     *
     * @return
     */
    Team getTeam();

    /**
     * 获取角色。
     *
     * @return
     */
    Role getRole();

    /**
     * 获取武将。
     *
     * @return
     */
    Hero getHero();

    /**
     * 是否已阵亡。
     *
     * @return
     */
    boolean isDead();

    /**
     * 获取当前位置。
     *
     * @return
     */
    Position getPosition();

    /**
     * 获取手牌区。
     *
     * @return
     */
    HandArea getHand();

    /**
     * 获取装备区。
     *
     * @return
     */
    EquipArea getEquip();

    /**
     * 获取判定区。
     *
     * @return
     */
    JudgementArea getJudgement();
}
