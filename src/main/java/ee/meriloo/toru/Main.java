package ee.meriloo.toru;

import ee.meriloo.toru.model.Pipeline;
import ee.meriloo.toru.model.Rectangle;
import ee.meriloo.toru.service.InputParsingService;
import ee.meriloo.toru.service.PipelineBuilder;
import ee.meriloo.toru.service.RectangleBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Main {


    @Autowired
    RectangleBuilder rectangleBuilder;
    @Autowired
    PipelineBuilder pipelineBuilder;
    @Autowired
    InputParsingService inputParsingService;


    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Main main = context.getBean(Main.class);

        String input = "100, 35, 75, 50, 80, 100, 37";
        List<Double> rectangleDimensions = main.inputParsingService.getRectangleDimension(input);
        List<Double> pipesDiameters = main.inputParsingService.getPipesDiameters(input);
        Rectangle firstRectangle = main.rectangleBuilder.buildRectangle(rectangleDimensions);
        Pipeline pipeline = main.pipelineBuilder.buildPipeLine(pipesDiameters);
        System.out.println();

    }

}
