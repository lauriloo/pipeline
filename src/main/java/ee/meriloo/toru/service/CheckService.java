package ee.meriloo.toru.service;

import ee.meriloo.toru.model.Junction;
import ee.meriloo.toru.model.Pipeline;
import ee.meriloo.toru.model.Point;
import ee.meriloo.toru.model.Rectangle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CheckService {

    private static final double STEP = 1000.0;
    private static final double ZERO = 0.0;
    private static final String NEXT_JUNCTION_FIRST_PIPE = "Testime ühendust.. Esimene Toru: ";
    private static final String SECOND_PIPE = " Teine toru: ";

    @Autowired
    private RectangleMovingService movingService;
    @Autowired
    private RectangleSlidingService slidingService;


    public boolean check(Rectangle rectangle, Pipeline pipeline) {
        return checkPipesDiameters(rectangle, pipeline)
                && checkJunctions(rectangle, pipeline);
    }

    private boolean checkJunctions(Rectangle rectangle, Pipeline pipeline) {
        boolean rectangleTurned = false;
        for (Junction junction : pipeline.getJunctions()) {
            System.out.println(NEXT_JUNCTION_FIRST_PIPE + junction.getFirstPipeDiameter().toString() + SECOND_PIPE
                    + junction.getSecondPipeDiameter().toString());
            if (rectangleTurned && checkMoveRight(rectangle, junction)) {
                rectangleTurned = false;
                continue;
            }
            movingService.moveToJunctionCorner(rectangle, junction, rectangleTurned);

            boolean slidingHasNotEnded = true;
            BigDecimal step = rectangle.getLength().divide(BigDecimal.valueOf(STEP));
            while (slidingHasNotEnded) {
                slidingHasNotEnded = slidingService.slideRectangleRight(rectangle, junction, step);
                if (!fits(rectangle)) {
                    if (checkMoveRight(rectangle, junction)) {
                        rectangleTurned = !rectangleTurned;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean checkPipesDiameters(Rectangle rectangle, Pipeline pipeline) {
        return pipesDiametersAreBiggerThanRectangleWidth(rectangle, pipeline);
    }

    private boolean fits(Rectangle rectangle) {
        Point rightDownCornerB = rectangle.getRightDownCornerB();
        Point rightUpCornerD = rectangle.getRightUpCornerD();
        return valueOfYWhenXequalsZero(rightDownCornerB, rightUpCornerD).compareTo(BigDecimal.valueOf(ZERO)) < 0;
    }

    private boolean pipesDiametersAreBiggerThanRectangleWidth(Rectangle rectangle, Pipeline pipeline) {
        return pipeline.getJunctions().stream()
                .noneMatch(e -> rectangleDoesNotFitToPipe(rectangle, e.getFirstPipeDiameter()));
    }

    private boolean rectangleDoesNotFitToPipe(Rectangle rectangle, BigDecimal pipeDiameter) {
        return rectangle.getWidth().compareTo(pipeDiameter) > 0;
    }

    private boolean checkMoveRight(Rectangle rectangle, Junction junction) {
        return !(rectangle.getLength().compareTo(junction.getSecondPipeDiameter()) > 0);
    }

    private BigDecimal valueOfYWhenXequalsZero(Point firstPoint, Point secondPoint) {
        double x1 = firstPoint.getxCoord().doubleValue();
        double y1 = firstPoint.getyCoord().doubleValue();
        double x2 = secondPoint.getxCoord().doubleValue();
        double y2 = secondPoint.getyCoord().doubleValue();
        double y2MinusY1 = y2 - y1;
        double x1MinusX2 = x1 - x2;
        if (x1MinusX2 == 0) {
            x1MinusX2 = Double.MIN_VALUE;
        }
        double divide = y2MinusY1 / x1MinusX2;
        return BigDecimal.valueOf((divide * x1) + (y1));
    }
}
