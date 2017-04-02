package ee.meriloo.toru.service;

import ee.meriloo.toru.model.Point;
import ee.meriloo.toru.model.Rectangle;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class RectangleFitCheckService {

    public boolean fits(Rectangle rectangle) {
        Point rightDownCornerB = rectangle.getRightDownCornerB();
        Point rightUpCornerD = rectangle.getRightUpCornerD();
        return valueOfYWhenXequalsZero(rightDownCornerB, rightUpCornerD).compareTo(BigDecimal.valueOf(0.0)) < 0;
    }

    private BigDecimal valueOfYWhenXequalsZero(Point firstPoint, Point secondPoint) {
        double x1 = firstPoint.getxCoord().doubleValue();
        double y1 = firstPoint.getyCoord().doubleValue();
        double x2 = secondPoint.getxCoord().doubleValue();
        double y2 = secondPoint.getyCoord().doubleValue();
        double y2MinusY1 = y2 - y1;
        double x1MinusX2 = x1 - x2;
        if (x1MinusX2 == 0) System.out.println("ongi null");
        double divide = y2MinusY1/x1MinusX2;
        return BigDecimal.valueOf((divide*x1) + (y1));
    }

}
