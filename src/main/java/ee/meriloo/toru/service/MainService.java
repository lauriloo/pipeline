package ee.meriloo.toru.service;

import ee.meriloo.toru.model.Junction;
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
    private static final String NEXT_JUNCTION_FIRST_PIPE = "Testime ühendust.. Esimene Toru: ";
    private static final String SECOND_PIPE = " Teine toru: ";
    private static final double STEP = 1000.0;

    @Autowired
    private RectangleBuilder rectangleBuilder;
    @Autowired
    private PipelineBuilder pipelineBuilder;
    @Autowired
    private InputParsingService inputParsingService;
    @Autowired
    private RectangleMovingService movingService;
    @Autowired
    private RectangleSlidingService slidingService;
    @Autowired
    private RectangleFitCheckService fitCheckService;

    public void buildAndTestPipeline(String input) throws Exception {
        List<BigDecimal> rectangleDimensions = inputParsingService.getRectangleDimension(input);
        List<BigDecimal> pipesDiameters = inputParsingService.getPipesDiameters(input);
        Rectangle rectangle = rectangleBuilder.buildRectangle(rectangleDimensions);
        Pipeline pipeline = pipelineBuilder.buildPipeLine(pipesDiameters);

        runRectangleThroughPipelineAndPrintResultsToConsole(rectangle, pipeline);
    }

    private void runRectangleThroughPipelineAndPrintResultsToConsole(Rectangle rectangle, Pipeline pipeline) {
        for (Junction junction : pipeline.getJunctions()) {
            System.out.println(NEXT_JUNCTION_FIRST_PIPE + junction.getFirstPipeDiameter().toString() + SECOND_PIPE
                    + junction.getSecondPipeDiameter().toString());
            movingService.moveToJunctionCorner(rectangle, junction);

            boolean slidingHasNotEnded = true;
            BigDecimal step = rectangle.getLength().divide(BigDecimal.valueOf(STEP));
            while (slidingHasNotEnded) {
                slidingHasNotEnded = slidingService.slideRectangleRight(rectangle, junction, step);
                boolean fits = fitCheckService.fits(rectangle);
                if (!fits) {
                    System.out.println(DOESNT_FIT);
                    return;
                }
            }
        }
        System.out.println(FITS);
    }
}
