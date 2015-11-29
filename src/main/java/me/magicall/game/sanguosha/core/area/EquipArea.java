package me.magicall.game.sanguosha.core.area;

import com.google.common.collect.Lists;
import me.magicall.game.card.Card;
import me.magicall.game.card.CardType;
import me.magicall.game.sanguosha.core.card.CardTypes;
import me.magicall.game.sanguosha.core.gaming.GameException;
import me.magicall.game.sanguosha.core.gaming.Sanguosha;
import me.magicall.game.sanguosha.core.player.Player;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 装备区。
 *
 * @author Liang Wenjian
 */
public class EquipArea extends AbsPlayerCardArea<List<Card>> {

    public static final int WEAPON_INDEX = 0;
    public static final int SHIELD_INDEX = 1;
    public static final int DEFENCE_HORSE_INDEX = 2;
    public static final int ATTACK_HORSE_INDEX = 3;

    public EquipArea(final Sanguosha game, final Player owner) {
        super(game, Lists.newArrayList(null, null, null, null), owner);
    }

    @Override
    public List<Card> getCards() {
        return super.getCards().stream().filter(e -> e != null).collect(Collectors.toList());
    }

    public boolean canGain(final Card card) {
        //TODO:这些应该做到规则去。
        final CardType type = card.getType();
        if (!type.is(CardTypes.装备)) {
            return false;
        }
        final List<Card> cards = getCards();
        if (type.is(CardTypes.武器) && cards.get(WEAPON_INDEX) != null) {
            return false;
        }
        if (type.is(CardTypes.防具) && cards.get(SHIELD_INDEX) != null) {
            return false;
        }
        if (type.is(CardTypes.防御马) && cards.get(DEFENCE_HORSE_INDEX) != null) {
            return false;
        }
        return !(type.is(CardTypes.进攻马) && cards.get(ATTACK_HORSE_INDEX) != null);
    }

    public void setWeapon(final Card weapon) {
        if (!weapon.getType().is(CardTypes.武器)) {
            throw new GameException();
        }
        getCards().set(WEAPON_INDEX, weapon);
    }

    public Card getWeapon() {
        return getCards().get(WEAPON_INDEX);
    }

    public void setShield(final Card shield) {
        if (!shield.getType().is(CardTypes.防具)) {
            throw new GameException();
        }
        getCards().set(SHIELD_INDEX, shield);
    }

    public Card getShield() {
        return getCards().get(SHIELD_INDEX);
    }

    public void setAttackHorse(final Card attackHorse) {
        if (!attackHorse.getType().is(CardTypes.进攻马)) {
            throw new GameException();
        }
        getCards().set(ATTACK_HORSE_INDEX, attackHorse);
    }

    public Card getAttackHorse() {
        return getCards().get(ATTACK_HORSE_INDEX);
    }

    public void setDefenceHorse(final Card defenceHorse) {
        if (!defenceHorse.getType().is(CardTypes.进攻马)) {
            throw new GameException();
        }
        getCards().set(DEFENCE_HORSE_INDEX, defenceHorse);
    }

    public Card getDefenceHorse() {
        return getCards().get(DEFENCE_HORSE_INDEX);
    }
}
