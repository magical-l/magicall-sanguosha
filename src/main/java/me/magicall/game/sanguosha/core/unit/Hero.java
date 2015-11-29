package me.magicall.game.sanguosha.core.unit;

import com.google.common.collect.Lists;
import me.magicall.game.sanguosha.core.area.EquipArea;
import me.magicall.game.sanguosha.core.area.HandArea;
import me.magicall.game.sanguosha.core.area.JudgementArea;
import me.magicall.game.sanguosha.core.gaming.Sanguosha;
import me.magicall.game.sanguosha.core.gaming.position.Position;
import me.magicall.game.sanguosha.core.player.GamingPlayer;
import me.magicall.game.sanguosha.core.skill.Skill;

import java.util.Collection;

/**
 * 武将。
 * 参考：http://gw.sanguosha.com/data/newsDetail.asp?id=230&CategoryID=5016
 *
 * @author Liang Wenjian
 */
public class Hero implements Unit {

    private final HeroCfg heroCfg;

    private final Sanguosha game;
    private GamingPlayer player;
    //角色的体力有可能小于0。
    private final Hp hp;

    //下面这些初始化数据在游戏中是可以改变的。
    private Country country;
    private Gender gender;
    private Collection<Skill> skills;

    public Hero(final HeroCfg heroCfg, final Sanguosha game, final GamingPlayer player, final Position coordinate) {
        this.heroCfg = heroCfg;
        this.game = game;
        this.player = player;
        country = heroCfg.getCountry();
        skills = Lists.newArrayList(heroCfg.getSkills());
        hp = new HpImpl(heroCfg.getMaxHp());
    }

    //-------------------------基本属性

    /**
     * 获取武将初始化配置。
     *
     * @return
     */
    @Override
    public HeroCfg getCfg() {
        return heroCfg;
    }

    /**
     * 获取武将性别。
     *
     * @return
     */
    public Gender getGender() {
        return getCfg().getGender();
    }

    /**
     * 获取武将的体力牌。
     *
     * @return
     */
    @Override
    public Hp getHp() {
        return hp;
    }

    /**
     * 获取武将已损失体力值。
     *
     * @return
     */
    public double getLostHp() {
        //当角色的体力降到0或更低时，其已损失的体力值等于其体力上限。
        return hp.getValue() <= 0 ? hp.getMax() : hp.getLost();
    }

    /**
     * 获取武将的势力。
     *
     * @return
     */
    public Country getCountry() {
        return country;
    }

    /**
     * 设置武将的势力。
     *
     * @param country
     */
    public void setCountry(final Country country) {
        this.country = country;
    }

    /**
     * 获取武将的技能。
     *
     * @return
     */
    public Collection<Skill> getSkills() {
        return skills;
    }

    /**
     * 设置武将的技能。
     *
     * @param skills
     */
    public void setSkills(final Collection<Skill> skills) {
        this.skills = skills;
    }

    /**
     * 获取武将所在的游戏局。
     *
     * @return
     */
    public Sanguosha getGame() {
        return game;
    }

    /**
     * 获取武将的玩家。
     *
     * @return
     */
    public GamingPlayer getPlayer() {
        return player;
    }

    /**
     * 设置武将的玩家。
     *
     * @param player
     */
    public void setPlayer(final GamingPlayer player) {
        this.player = player;
    }

    /**
     * 获取武将的手牌区。
     *
     * @return
     */
    public HandArea getHand() {
        return player.getHand();
    }

    /**
     * 获取武将的设备区。
     *
     * @return
     */
    public EquipArea getEquip() {
        return player.getEquip();
    }

    /**
     * 获取武将的判定区。
     *
     * @return
     */
    public JudgementArea getJudgement() {
        return player.getJudgement();
    }

    @Override
    public String toString() {
        return "Hero_"+getName() + ":{" +
                "skills:" + skills +
                ", country:" + country +
                ", hp:" + hp +
                ", player:" + player +
                ", game:" + game +
                '}';
    }
}
