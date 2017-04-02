package ee.meriloo.toru.model;

import java.math.BigDecimal;
import java.util.List;

public class Pipeline {

    private List<BigDecimal> pipes;
    private List<Junction> junctions;

    public Pipeline(List<BigDecimal> pipes, List<Junction> junctions) {
        this.pipes = pipes;
        this.junctions = junctions;
    }

    public List<BigDecimal> getPipes() {
        return pipes;
    }

    public List<Junction> getJunctions() {
        return junctions;
    }
}
