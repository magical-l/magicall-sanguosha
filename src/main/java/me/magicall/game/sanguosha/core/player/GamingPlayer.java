package me.magicall.game.sanguosha.core.player;

import me.magicall.game.sanguosha.core.area.EquipArea;
import me.magicall.game.sanguosha.core.area.HandArea;
import me.magicall.game.sanguosha.core.area.JudgementArea;
import me.magicall.game.sanguosha.core.gaming.Sanguosha;
import me.magicall.game.sanguosha.core.gaming.Team;
import me.magicall.game.sanguosha.core.gaming.option.Options;
import me.magicall.game.sanguosha.core.gaming.option.Selection;
import me.magicall.game.sanguosha.core.gaming.position.Position;
import me.magicall.game.sanguosha.core.unit.Hero;

import java.util.Collections;

/**
 * 游戏中的玩家。
 *
 * @author Liang Wenjian
 */
public class GamingPlayer implements SanguoshaPlayer {

    private final String name;

    private final Sanguosha game;

    private Team team;

    private Position position;
    /**
     * 身份
     */
    private Role role;
    /**
     * 武将
     */
    private Hero hero;
    /**
     * 玩家代理
     */
    private IO io;//player在游戏中有可能会被替换成AI。
    /**
     * 是否已阵亡
     */
    private boolean dead;

    //各个牌区域
    private final HandArea hand;
    private final EquipArea equip;
    private final JudgementArea judgement;

    public GamingPlayer(final String name, final Sanguosha game) {
        this.name = name;
        this.game = game;
        hand = new HandArea(game, this);
        equip = new EquipArea(game, this);
        judgement = new JudgementArea(game, this);
    }

    @Override
    public <T extends Selection> T requireInput(final Options<T> options) {
        return io.requireInput(options);
    }

    @Override
    public void output(final Object o) {
        io.output(o);
    }

    @Override
    public Role getRole() {
        return role;
    }

    public void setRole(final Role role) {
        this.role = role;
    }

    @Override
    public Hero getHero() {
        return hero;
    }

    public void setHero(final Hero hero) {
        this.hero = hero;
    }

    public IO getIO() {
        return io;
    }

    public void setIO(final IO io) {
        this.io = io;
    }

    @Override
    public boolean isDead() {
        return dead;
    }

    public void setDead(final boolean dead) {
        this.dead = dead;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    public void setPosition(final Position position) {
        this.position = position;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Sanguosha getGame() {
        return game;
    }

    @Override
    public Team getTeam() {
        return team;
    }

    @Override
    public HandArea getHand() {
        return hand;
    }

    @Override
    public EquipArea getEquip() {
        return equip;
    }

    @Override
    public JudgementArea getJudgement() {
        return judgement;
    }

    public void setTeam(final Team team) {
        this.team = team;
        if (!team.contains(this)) {
            team.playersJoinIn(Collections.singletonList(this));
        }
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + hashCode() + ":{" +
                "role:" + role +
                ", hero:" + hero +
                ", io:" + io +
                ", dead:" + dead +
                '}';
    }
}
