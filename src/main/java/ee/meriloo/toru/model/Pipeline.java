package ee.meriloo.toru.model;

import java.util.List;

public class Pipeline {

    private List<Double> pipes;
    private List<Junction> junctions;

    public Pipeline(List<Double> pipes, List<Junction> junctions) {
        this.pipes = pipes;
        this.junctions = junctions;
    }

    public List<Double> getPipes() {
        return pipes;
    }

    public List<Junction> getJunctions() {
        return junctions;
    }
}
