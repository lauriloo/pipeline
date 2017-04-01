package ee.meriloo.toru.service.builders;


import ee.meriloo.toru.model.PipeJunction;
import ee.meriloo.toru.model.Pipeline;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PipelineBuilder {

    public Pipeline buildPipeLine(List<Double> pipes) throws Exception {
        if (isNotValid(pipes)) throw new Exception("Can't build pipeline");
        return new Pipeline(pipes, getPipeJunctions(pipes));
    }

    private boolean isNotValid(List<Double> pipes) {
        return pipes == null || pipes.size() < 2;
    }

    private List<PipeJunction> getPipeJunctions(List<Double> pipes) {
        List<PipeJunction> junctions = new ArrayList<>();
        for(int index = 1; index < pipes.size(); index++) {
            junctions.add(new PipeJunction(pipes.get(index -1), pipes.get(index)));
        }
        return junctions;
    }

}
