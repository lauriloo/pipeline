package ee.meriloo.toru.service;


import ee.meriloo.toru.model.Junction;
import ee.meriloo.toru.model.Point;
import ee.meriloo.toru.model.Rectangle;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class RectangleSlidingService {

    public boolean slideRectangleRight(Rectangle rectangle, Junction junction, BigDecimal step) {
        Point newPointA = getNewPointA(rectangle, step);
        if (slidingHasEnded(rectangle, junction, newPointA)) return false;


        BigDecimal axDistanceFromCorner = getAxDistanceFromCorner(newPointA, junction);
        BigDecimal sinAlpha = getSinAlpha(axDistanceFromCorner, rectangle.getLength());
        BigDecimal cosAlpha = getCosAlpha(axDistanceFromCorner, rectangle.getLength());
        BigDecimal deltaX = getDeltaX(cosAlpha, rectangle.getWidth());
        BigDecimal deltaY = getDeltaY(sinAlpha, rectangle.getWidth());

        Point newPointB = getNewPointB(newPointA, deltaX, deltaY);
        Point newPointC = getNewPointC(cosAlpha, rectangle, junction);
        Point newPointD = getNewPointD(newPointC, deltaX, deltaY);

        rectangle.setLeftDownCornerA(newPointA);
        rectangle.setRightDownCornerB(newPointB);
        rectangle.setLeftUpCornerC(newPointC);
        rectangle.setRightUpCornerD(newPointD);
        return true;
    }

    private boolean slidingHasEnded(Rectangle rectangle, Junction junction, Point newPointA) {
        return getAxDistanceFromCorner(newPointA, junction).compareTo(rectangle.getLength()) > 0;
    }

    private Point getNewPointA(Rectangle rectangle, BigDecimal step) {
        BigDecimal axNew = rectangle.getLeftDownCornerA().getxCoord().add(step);
        return new Point(axNew, rectangle.getLeftDownCornerA().getyCoord());
    }

    private Point getNewPointB(Point newPointA, BigDecimal deltaX, BigDecimal deltaY) {
        return new Point(newPointA.getxCoord().add(deltaX), newPointA.getyCoord().add(deltaY));
    }

    private Point getNewPointC(BigDecimal cosAlpha, Rectangle rectangle, Junction junction) {
        BigDecimal cy = rectangle.getLength().multiply(cosAlpha).subtract(junction.getSecondPipeDiameter());
        BigDecimal cx = junction.getFirstPipeDiameter().negate();
        return new Point(cx, cy);
    }

    private Point getNewPointD(Point newPointC, BigDecimal deltaX, BigDecimal deltaY) {
        return new Point(newPointC.getxCoord().add(deltaX), newPointC.getyCoord().add(deltaY));
    }

    private BigDecimal getAxDistanceFromCorner(Point pointA, Junction junction) {
        return junction.getFirstPipeDiameter().add(pointA.getxCoord());
    }

    private BigDecimal getSinAlpha(BigDecimal axDistanceFromCorner, BigDecimal rectangleLength) {
        return axDistanceFromCorner.divide(rectangleLength);
    }

    private BigDecimal getCosAlpha(BigDecimal axDistanceFromCorner, BigDecimal rectangleLength) {
        BigDecimal sinAlpha = getSinAlpha(axDistanceFromCorner, rectangleLength);
        double angle = Math.asin(sinAlpha.doubleValue());
        return BigDecimal.valueOf(Math.cos(angle));
    }

    private BigDecimal getDeltaX(BigDecimal cosAlpha, BigDecimal rectangleWidth) {
        return rectangleWidth.multiply(cosAlpha);
    }

    private BigDecimal getDeltaY(BigDecimal sinAlpha, BigDecimal rectangleWidth) {
        return rectangleWidth.multiply(sinAlpha);
    }


}
