package ee.meriloo.toru.model;

import java.util.List;

public class Pipeline {

    private List<Junction> junctions;

    public Pipeline(List<Junction> junctions) {
        this.junctions = junctions;
    }

    public List<Junction> getJunctions() {
        return junctions;
    }
}
