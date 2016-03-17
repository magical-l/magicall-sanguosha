package me.magicall.game.sanguosha.core;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import me.magicall.game.sanguosha.core.area.CardStack;
import me.magicall.game.sanguosha.core.card.Card;
import me.magicall.game.sanguosha.core.card.CardCfg;
import me.magicall.game.sanguosha.core.card.GamingCard;
import me.magicall.game.sanguosha.core.gaming.Sanguosha;
import me.magicall.game.sanguosha.core.gaming.SanguoshaCfg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author Liang Wenjian
 */
public class DefaultCardManagerImpl implements CardManager {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final SanguoshaCfg cfg;
    /**
     * 牌堆。
     */
    private final CardStack cardStack;

    /**
     * 牌库。键为牌在游戏中的id。
     */
    private final Map<Integer, GamingCard> idCardMap = Maps.newHashMap();

    public DefaultCardManagerImpl(final Sanguosha game) {
        cfg = game.getCfg();
        cardStack = new CardStack(game);
    }

    @Override
    public void initCardStack() {
        final Map<CardCfg, Integer> cardCfgCountMap = cfg.getCountOfCardCfg();
        int id = 1;
        final List<Card> cards = Lists.newArrayList();
        for (final Entry<CardCfg, Integer> entry : cardCfgCountMap.entrySet()) {
            final CardCfg cardCfg = entry.getKey();
            final int count = entry.getValue();
            for (int i = 0; i < count; ++i) {
                final GamingCard card = new GamingCard(id, cardCfg);
                cards.add(card);
                idCardMap.put(id, card);
                id++;
            }
        }
        Collections.shuffle(cards);
        cardStack.gain(cards);

        logger.debug("initCardStack end:" + cardStack);
    }

    @Override
    public Card getCard(final Integer cardId) {
        return idCardMap.get(cardId);
    }
}
