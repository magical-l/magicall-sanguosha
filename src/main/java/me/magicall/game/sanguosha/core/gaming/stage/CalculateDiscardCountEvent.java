package me.magicall.game.sanguosha.core.gaming.stage;

import me.magicall.game.sanguosha.core.gaming.event.EventTemplate;
import me.magicall.game.sanguosha.core.gaming.Sanguosha;

/**
 * @author Liang Wenjian
 */
public class CalculateDiscardCountEvent extends EventTemplate<DiscardStage,Sanguosha> {

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
