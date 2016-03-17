package me.magicall.game.sanguosha.core.gaming.stage;

import me.magicall.game.sanguosha.core.Targetable;
import me.magicall.game.sanguosha.core.gaming.event.EventTemplate;

/**
 * @author Liang Wenjian
 */
public class CalculateDiscardCountEvent extends EventTemplate<DiscardStage, Targetable> {

    private int availableRemainCount;

    public CalculateDiscardCountEvent(final DiscardStage source, final int availableRemainCount) {
        super(source);
        this.availableRemainCount = availableRemainCount;
    }

    public int getAvailableRemainCount() {
        return availableRemainCount;
    }

    public void setAvailableRemainCount(final int availableRemainCount) {
        this.availableRemainCount = availableRemainCount;
    }
}
