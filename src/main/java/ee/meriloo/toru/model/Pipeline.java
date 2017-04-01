package ee.meriloo.toru.model;

import java.util.ArrayList;
import java.util.List;

public class Pipeline {

    private List<Double> pipes = new ArrayList<>();
    private int index;

    public Pipeline(List<Double> pipes) {
        this.pipes = pipes;
        index = 0;
    }

    public PipeJunction getNextJunction() throws Exception {
        if (index + 2 >= pipes.size()) throw new Exception("No more Junctions");
        PipeJunction pipeJunction = new PipeJunction();
        pipeJunction.setFirstPipeDiameter(pipes.get(index++));
        pipeJunction.setSecondPipeDiameter(pipes.get(index++));
        return pipeJunction;
    }

}
