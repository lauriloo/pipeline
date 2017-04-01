package ee.meriloo.toru.service;


import ee.meriloo.toru.asjad.Torustik;

import java.util.*;

/**
 * Created by Lauri on 31.03.2017.
 */
public class TorustikBuilder {

    private static List<Long> torud = new ArrayList<>();

    public static void lisaToru(Long toru) {
        torud.add(toru);
    }

    public static Torustik buildTorustik() {
        Torustik torustik = new Torustik(TorustikBuilder.torud);
        TorustikBuilder.torud = new ArrayList<>();
        return torustik;
    }

    public static Torustik buildTorustik(Long... torud ) {
        for (Long toru:Arrays.asList(torud)) {
            lisaToru(toru);
        }
        return buildTorustik();
    }


}
