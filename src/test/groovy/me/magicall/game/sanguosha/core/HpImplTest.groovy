package me.magicall.game.sanguosha.core

import me.magicall.game.sanguosha.core.unit.HpImpl
import spock.lang.Specification

/**
 * @author Liang Wenjian
 */
class HpImplTest extends Specification {
    def "test init1"() {
        HpImpl hp = new HpImpl(100)
        expect:
        hp.value == 100
        hp.max == 100
        hp.max == hp.value
    }

    def "test init2"() {
        def max = 1000
        def value = 100
        def lost = 10
        HpImpl hp = new HpImpl(max, value)
        expect:
        hp.value == value
        hp.max == max

        when:
        hp.decrease(lost)
        then:
        hp.max == max
        hp.value == value - lost
        !hp.full
        hp.notFull
        hp.lost == hp.max - hp.value
    }
}
