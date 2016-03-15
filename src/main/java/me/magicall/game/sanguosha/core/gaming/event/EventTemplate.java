package me.magicall.game.sanguosha.core.gaming.event;

import com.google.common.collect.Lists;
import me.magicall.game.sanguosha.core.Targetable;

import java.util.List;

/**
 * 事件模板。
 *
 * @author Liang Wenjian
 */
public class EventTemplate<S, T extends Targetable> implements Event<S, T> {

    protected S source;
    protected List<T> targets;

    public EventTemplate() {
        this(null);
    }

    public EventTemplate(final S source) {
        this(source, Lists.newArrayList());
    }

    public EventTemplate(final S source, final T target) {
        this(source, Lists.newArrayList(target));
    }

    public EventTemplate(final S source, final List<T> targets) {
        this.source = source;
        this.targets = targets;
    }

    @Override
    public S getSource() {
        return source;
    }

    @Override
    public void setSource(final S source) {
        this.source = source;
    }

    @Override
    public Object getObjectSource() {
        return null;//TODO
    }

    @Override
    public void setObjectSource(Object objectSource) {
        //TODO
    }

    @Override
    public List<T> getTargets() {
        return targets;
    }

    @Override
    public void setTargets(final List<T> targets) {
        this.targets = targets;
    }

    @Override
    public List<?> getSecondaryTargets() {
        return null;//TODO
    }

    @Override
    public void setSecondaryTargets(List<?> secondaryTargets) {
        //TODO
    }
}
