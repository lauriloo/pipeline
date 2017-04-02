package ee.meriloo.toru;

import ee.meriloo.toru.model.Junction;
import ee.meriloo.toru.model.Pipeline;
import ee.meriloo.toru.model.Rectangle;
import ee.meriloo.toru.service.RectangleFitCheckService;
import ee.meriloo.toru.service.RectangleSlidingService;
import ee.meriloo.toru.service.input.InputParsingService;
import ee.meriloo.toru.service.RectangleMovingService;
import ee.meriloo.toru.service.builders.PipelineBuilder;
import ee.meriloo.toru.service.builders.RectangleBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class Main {


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


    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Main main = context.getBean(Main.class);

//        String input = "60, 120, 100, 75";
//        String input = "100, 35, 75, 50, 80, 100, 37";
        String input = "70, 50, 60, 60, 55, 90";
        List<BigDecimal> rectangleDimensions = main.inputParsingService.getRectangleDimension(input);
        List<BigDecimal> pipesDiameters = main.inputParsingService.getPipesDiameters(input);
        Rectangle rectangle = main.rectangleBuilder.buildRectangle(rectangleDimensions);
        Pipeline pipeline = main.pipelineBuilder.buildPipeLine(pipesDiameters);
        Junction junction = pipeline.getJunctions().get(2);
        main.movingService.moveToJunctionCorner(rectangle, junction);

        boolean slidingHasNotEnded = true;
        BigDecimal step = rectangle.getLength().divide(BigDecimal.valueOf(100.0));
        while (slidingHasNotEnded) {
            slidingHasNotEnded = main.slidingService.slideRectangleRight(rectangle, junction, step);
            boolean fits = main.fitCheckService.fits(rectangle);
            if (!fits) {
                slidingHasNotEnded = false;
                System.out.println("Does not fit");
            } else if (!slidingHasNotEnded) {
                System.out.println("Fits");
            }
        }

        System.out.println();

    }

}
