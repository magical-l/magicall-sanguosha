package me.magicall.game.sanguosha.core

import me.magicall.game.sanguosha.core.unit.HpImpl
import spock.lang.Specification

/**
 * @author Liang Wenjian
 */
class HpImplTest extends Specification {
    def "test HpImpl(double)"() {
        HpImpl hp = new HpImpl((double) suppose_max)
        expect:
        expect_hp == hp.value
        expect_max == hp.max
        hp.max == hp.value
        where:
        suppose_max         | expect_max          | expect_hp
        100                 | 100                 | 100
        0                   | 0                   | 0
        -0                  | -0                  | -0
        1                   | 1                   | 1
        -1                  | -1                  | -1
        982.1883            | 982.1883            | 982.1883
        Integer.MAX_VALUE   | Integer.MAX_VALUE   | Integer.MAX_VALUE
        Long.MAX_VALUE      | Long.MAX_VALUE      | Long.MAX_VALUE
        Float.MAX_VALUE     | Float.MAX_VALUE     | Float.MAX_VALUE
        Double.MAX_VALUE    | Double.MAX_VALUE    | Double.MAX_VALUE
        Byte.MAX_VALUE      | Byte.MAX_VALUE      | Byte.MAX_VALUE
        Character.MAX_VALUE | Character.MAX_VALUE | Character.MAX_VALUE
        Short.MAX_VALUE     | Short.MAX_VALUE     | Short.MAX_VALUE
        Integer.MIN_VALUE   | Integer.MIN_VALUE   | Integer.MIN_VALUE
        Long.MIN_VALUE      | Long.MIN_VALUE      | Long.MIN_VALUE
        Float.MIN_VALUE     | Float.MIN_VALUE     | Float.MIN_VALUE
        Double.MIN_VALUE    | Double.MIN_VALUE    | Double.MIN_VALUE
        Byte.MIN_VALUE      | Byte.MIN_VALUE      | Byte.MIN_VALUE
        Character.MIN_VALUE | Character.MIN_VALUE | Character.MIN_VALUE
        Short.MIN_VALUE     | Short.MIN_VALUE     | Short.MIN_VALUE
    }

    def "test HpImpl(double,double)"() {
        HpImpl hp = new HpImpl((double) suppose_max, (double) suppose_value)
        expect:
        expect_hp == hp.value
        expect_max == hp.max
        where:
        suppose_max         | suppose_value       | expect_max          | expect_hp
        100                 | 100                 | 100                 | 100
        100                 | 99                  | 100                 | 99
        Integer.MIN_VALUE   | Integer.MAX_VALUE   | Integer.MIN_VALUE   | Integer.MAX_VALUE
        Long.MIN_VALUE      | Long.MAX_VALUE      | Long.MIN_VALUE      | Long.MAX_VALUE
        Float.MIN_VALUE     | Float.MAX_VALUE     | Float.MIN_VALUE     | Float.MAX_VALUE
        Double.MIN_VALUE    | Double.MAX_VALUE    | Double.MIN_VALUE    | Double.MAX_VALUE
        Byte.MIN_VALUE      | Byte.MAX_VALUE      | Byte.MIN_VALUE      | Byte.MAX_VALUE
        Character.MIN_VALUE | Character.MAX_VALUE | Character.MIN_VALUE | Character.MAX_VALUE
        Short.MIN_VALUE     | Short.MAX_VALUE     | Short.MIN_VALUE     | Short.MAX_VALUE

        Integer.MAX_VALUE   | Integer.MIN_VALUE   | Integer.MAX_VALUE   | Integer.MIN_VALUE
        Long.MAX_VALUE      | Long.MIN_VALUE      | Long.MAX_VALUE      | Long.MIN_VALUE
        Float.MAX_VALUE     | Float.MIN_VALUE     | Float.MAX_VALUE     | Float.MIN_VALUE
        Double.MAX_VALUE    | Double.MIN_VALUE    | Double.MAX_VALUE    | Double.MIN_VALUE
        Byte.MAX_VALUE      | Byte.MIN_VALUE      | Byte.MAX_VALUE      | Byte.MIN_VALUE
        Character.MAX_VALUE | Character.MIN_VALUE | Character.MAX_VALUE | Character.MIN_VALUE
        Short.MAX_VALUE     | Short.MIN_VALUE     | Short.MAX_VALUE     | Short.MIN_VALUE
    }

    def "test decrease"() {
        HpImpl hp = new HpImpl((double) suppose_max)
        hp.decrease((double) suppose_delta)
        expect:
        ((double) expect_max) == hp.max
        ((double) expect_hp) == hp.value
        where:
        suppose_max | suppose_delta | expect_max | expect_hp
        100         | 1             | 100        | 99
        0           | 1             | 0          | -1
        1           | 1             | 1          | 0
    }

    static final Random RANDOM = new Random()

}
