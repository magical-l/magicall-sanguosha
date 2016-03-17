package me.magicall.game.sanguosha.embedded.标准.cfg;

import me.magicall.game.sanguosha.core.Targetable;
import me.magicall.game.sanguosha.core.card.Card;
import me.magicall.game.sanguosha.core.card.CardCfg;
import me.magicall.game.sanguosha.core.card.CardTypes;
import me.magicall.game.sanguosha.core.card.Flower;
import me.magicall.game.sanguosha.core.gaming.Sanguosha;
import me.magicall.game.sanguosha.core.gaming.round.SanguoshaTurn;
import me.magicall.game.sanguosha.core.gaming.stage.PlayerPlayStage;
import me.magicall.game.sanguosha.core.gaming.stage.Stage;
import me.magicall.game.sanguosha.core.gaming.target.TargetSelector;
import me.magicall.game.sanguosha.core.player.GamingPlayer;
import me.magicall.game.sanguosha.core.skill.Effect;
import me.magicall.game.sanguosha.core.skill.Skill;
import me.magicall.game.sanguosha.core.unit.Hero;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * @author Liang Wenjian
 */
public class 乐不思蜀 extends CardCfg {

    public 乐不思蜀(final int point, final Flower flower) {
        super(CardTypes.延时锦囊, point, flower,//
                new 乐不思蜀Skill());//TODO
    }

    private static class 乐不思蜀Skill implements Skill {

        @Override
        public Effect<?> action(final Sanguosha game, final Hero hero, final List<Hero> targets,
                                final Collection<Card> resources) {
            if (judge()) {//判定生效
                return new Effect<Targetable>() {
                    @Override
                    public Sanguosha getGame() {
                        return game;
                    }

                    @Override
                    public Skill getSkill() {
                        return 乐不思蜀Skill.this;
                    }

                    @Override
                    public GamingPlayer getUser() {
                        return null;//TODO
                    }

                    @Override
                    public Collection<Card> getResources() {
                        return null;//TODO
                    }

                    @Override
                    public List<Targetable> getTargets() {
                        return null;//TODO
                    }

                    @Override
                    public void doEffect() {
                        //去掉当前回合的玩家出牌阶段。
                        final SanguoshaTurn curTurn = game.getCurTurn();
                        final List<? extends Stage> stages = curTurn.getFinishedStages();
                        for (final Iterator<? extends Stage> iterator = stages.iterator(); iterator.hasNext(); ) {
                            final Stage next = iterator.next();
                            if (next instanceof PlayerPlayStage) {
                                iterator.remove();
                            }
                        }
                    }
                };
            }
            return null;//TODO
        }

        private boolean judge() {
            return false;//TODO
        }

        @Override
        public TargetSelector getTargetSelector() {
            return null;//TODO
        }
    }
}
