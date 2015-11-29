package me.magicall.game.sanguosha.core.unit;

import com.google.common.collect.Lists;
import me.magicall.game.sanguosha.core.skill.Skill;

import java.util.Collection;

/**
 * 武将的初始设置。
 *
 * @author Liang Wenjian
 */
public class HeroCfg implements UnitCfg {

    private final String name;
    private final int maxHP;
    private final Country country;
    private final Gender gender;
    private final Collection<Skill> skills;

    public HeroCfg(final int maxHP, final Country country, final Gender gender, final Skill... skills) {
        this(maxHP, country, gender, Lists.newArrayList(skills));
    }

    public HeroCfg(final String name, final int maxHP, final Country country, final Gender gender,
                   final Skill... skills) {
        this(name, maxHP, country, gender, Lists.newArrayList(skills));
    }

    public HeroCfg(final int maxHP, final Country country, final Gender gender, final Collection<Skill> skills) {
        name = getClass().getName();
        this.maxHP = maxHP;
        this.country = country;
        this.gender = gender;
        this.skills = skills;
    }

    public HeroCfg(final String name, final int maxHP, final Country country, final Gender gender,
                   final Collection<Skill> skills) {
        this.name = name;
        this.maxHP = maxHP;
        this.country = country;
        this.gender = gender;
        this.skills = skills;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getMaxHp() {
        return maxHP;
    }

    public Country getCountry() {
        return country;
    }

    public Gender getGender() {
        return gender;
    }

    public Collection<Skill> getSkills() {
        return skills;
    }

    @Override
    public String toString() {
        return "HeroCfg_" + getName() + ":{" +
                "maxHP:" + maxHP +
                ", country:" + country +
                ", gender:" + gender +
                ", skills:" + skills +
                '}';
    }
}
