package me.magicall.game.sanguosha.embedded.军争;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import me.magicall.game.sanguosha.core.Status;
import me.magicall.game.sanguosha.embedded.标准.event.HarmedEvent;
import me.magicall.game.sanguosha.core.gaming.Sanguosha;
import me.magicall.game.sanguosha.core.unit.Hero;

/**
 * @author Liang Wenjian
 */
public class Linked implements Status {

    private static final Multimap<Sanguosha, Hero> LINKED_HEROES = HashMultimap.create();

    public Linked() {
        super();
    }

    @Override
    public String getName() {
        return "横置";
    }

    @Override
    public void whenGain(final Hero hero) {
        LINKED_HEROES.put(hero.getGame(), hero);
        //给武将加一个伤害监听器，当受到属性伤害，取出LINKED_HEROES，对所有武将造成同样的属性伤害。
        //TODO
    }

    private static void whenHarm(final HarmedEvent harmedEvent) {
//        final Hero hero = harmedEvent.getTargets();
        final int point = harmedEvent.getPoint();
        //TODO:去掉武将的横置状态
//        final Collection<Hero> heroes = LINKED_HEROES.get(hero.getGame());
//        heroes.stream().filter(h -> !Objects.equals(h, hero)).forEach(h -> {
//            h.injured(point);
//        });
    }
}
