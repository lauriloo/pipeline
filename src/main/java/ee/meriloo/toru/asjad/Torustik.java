package ee.meriloo.toru.asjad;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lauri on 31.03.2017.
 */
public class Torustik {

    private static List<Long> torud = new ArrayList<>();
    private static int index;

    public Torustik(List<Long> torud) {
        this.torud = torud;
        index = 0;
    }

    public static TorudeYhendus getJarmineTorudepaar() {
        if (index + 2 >= torud.size()) return null;
        TorudeYhendus torudeYhendus = new TorudeYhendus();
        torudeYhendus.setEsimeneToru(torud.get(index++));
        torudeYhendus.setTeineToru(torud.get(index++));
        return torudeYhendus;
    }

}
