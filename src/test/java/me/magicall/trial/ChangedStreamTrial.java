package me.magicall.trial;

import com.google.common.collect.Lists;

import java.util.Collection;
import java.util.List;

/**
 * @author Liang Wenjian
 */
public class ChangedStreamTrial {
    public static void main(final String[] args) {
//        a();
        final List<Integer> coll = initColl();
        for (int i = 0; i < coll.size(); i++) {
            if (coll.get(i) % 2 == 0) {
                coll.add(1);
            }
        }
        System.out.println("ChangedStreamTrial.main");
    }

    private static void a() {
        final Collection<Integer> coll = initColl();
        coll.stream().forEach(e -> {
            if (e % 2 == 0) {
                coll.add(1);
            }
        });
    }

    private static List<Integer> initColl() {
        return Lists.newArrayList(1, 2, 3, 4);
    }
}
