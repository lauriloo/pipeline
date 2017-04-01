package ee.meriloo.toru.service;


import ee.meriloo.toru.model.Pipeline;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PipelineBuilder {

//    public Pipeline buildPipeLine(Double... pipes ) throws Exception {
//        return buildPipeLine(Arrays.asList(pipes));
//    }

    public Pipeline buildPipeLine(List<Double> pipes) throws Exception {
        if (isNotValid(pipes)) throw new Exception("Can't build pipeline");
        return new Pipeline(pipes);
    }

    private boolean isNotValid(List<Double> pipes) {
        return pipes == null || pipes.size() < 2;
    }

}
