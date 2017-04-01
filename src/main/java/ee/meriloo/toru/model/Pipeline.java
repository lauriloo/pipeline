package ee.meriloo.toru.model;

import java.util.List;

public class Pipeline {

    private List<Double> pipes;
    private List<PipeJunction> pipeJunctions;

    public Pipeline(List<Double> pipes, List<PipeJunction> pipeJunctions) {
        this.pipes = pipes;
        this.pipeJunctions = pipeJunctions;
    }

    public List<Double> getPipes() {
        return pipes;
    }

    public List<PipeJunction> getPipeJunctions() {
        return pipeJunctions;
    }
}
