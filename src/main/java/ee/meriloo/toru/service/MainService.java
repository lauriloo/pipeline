package ee.meriloo.toru.service;

import ee.meriloo.toru.model.Pipeline;
import ee.meriloo.toru.model.Rectangle;
import ee.meriloo.toru.service.builders.PipelineBuilder;
import ee.meriloo.toru.service.builders.RectangleBuilder;
import ee.meriloo.toru.service.input.InputParsingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class MainService {

    private static final String FITS = "Mahub";
    private static final String DOESNT_FIT = "Ei Mahu";

    @Autowired
    private RectangleBuilder rectangleBuilder;
    @Autowired
    private PipelineBuilder pipelineBuilder;
    @Autowired
    private InputParsingService inputParsingService;
    @Autowired
    private CheckService checkService;

    public void buildAndTestPipeline(String input) throws Exception {
        List<BigDecimal> rectangleDimensions = inputParsingService.getRectangleDimension(input);
        List<BigDecimal> pipesDiameters = inputParsingService.getPipesDiameters(input);
        Rectangle rectangle = rectangleBuilder.buildRectangle(rectangleDimensions);
        Pipeline pipeline = pipelineBuilder.buildPipeLine(pipesDiameters);

        runRectangleThroughPipelineAndPrintResultsToConsole(rectangle, pipeline);
    }

    private void runRectangleThroughPipelineAndPrintResultsToConsole(Rectangle rectangle, Pipeline pipeline) {
        if (checkService.check(rectangle, pipeline)) {
            System.out.println(FITS);
        } else System.out.println(DOESNT_FIT);
    }

}
