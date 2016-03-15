package me.magicall.game.sanguosha.core.skill;

import me.magicall.game.sanguosha.core.card.Card;
import me.magicall.game.sanguosha.core.Targetable;
import me.magicall.game.sanguosha.core.gaming.Sanguosha;
import me.magicall.game.sanguosha.core.player.GamingPlayer;

import java.util.Collection;
import java.util.List;

/**
 * 技能产生的效果。
 *
 * @author Liang Wenjian
 */
public interface Effect<TARGET_TYPE extends Targetable> {

    Sanguosha getGame();

    Skill getSkill();

    GamingPlayer getUser();

    Collection<Card> getResources();

    List<TARGET_TYPE> getTargets();

    void doEffect();
}
