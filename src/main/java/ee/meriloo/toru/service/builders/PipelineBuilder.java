package ee.meriloo.toru.service.builders;


import ee.meriloo.toru.model.Junction;
import ee.meriloo.toru.model.Pipeline;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class PipelineBuilder {

    public Pipeline buildPipeLine(List<BigDecimal> pipes) throws Exception {
        if (isNotValid(pipes)) throw new Exception("Can't build pipeline");
        return new Pipeline(pipes, getPipeJunctions(pipes));
    }

    private boolean isNotValid(List<BigDecimal> pipes) {
        return pipes == null || pipes.size() < 2;
    }

    private List<Junction> getPipeJunctions(List<BigDecimal> pipes) {
        List<Junction> junctions = new ArrayList<>();
        for(int index = 1; index < pipes.size(); index++) {
            junctions.add(new Junction(pipes.get(index -1), pipes.get(index)));
        }
        return junctions;
    }

}
