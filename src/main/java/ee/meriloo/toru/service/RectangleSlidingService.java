package ee.meriloo.toru.service;


import ee.meriloo.toru.model.Junction;
import ee.meriloo.toru.model.Point;
import ee.meriloo.toru.model.Rectangle;
import org.springframework.stereotype.Service;

@Service
public class RectangleSlidingService {

    public boolean slideRectangleRight(Rectangle rectangle, Junction junction, Double step) {
        Point newPointA = getNewPointA(rectangle, step);
        if (slidingHasEnded(rectangle, junction, newPointA)) return false;


        Double axDistanceFromCorner = getAxDistanceFromCorner(newPointA, junction);
        Double sinAlpha = getSinAlpha(axDistanceFromCorner, rectangle.getLength());
        Double cosAlpha = getCosAlpha(axDistanceFromCorner, rectangle.getLength());
        Double deltaX = getDeltaX(cosAlpha, rectangle.getWidth());
        Double deltaY = getDeltaY(sinAlpha, rectangle.getWidth());

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
        return getAxDistanceFromCorner(newPointA, junction) > rectangle.getLength();
    }

    private Point getNewPointA(Rectangle rectangle, Double step) {
        Double axNew = rectangle.getLeftDownCornerA().getxCoord() + step;
        return new Point(axNew, rectangle.getLeftDownCornerA().getyCoord());
    }

    private Point getNewPointB(Point newPointA, Double deltaX, Double deltaY) {
        return new Point(newPointA.getxCoord() + deltaX, newPointA.getyCoord() + deltaY);
    }

    private Point getNewPointC(Double cosAlpha, Rectangle rectangle, Junction junction) {
        Double cy = rectangle.getLength()*cosAlpha - junction.getSecondPipeDiameter();
        Double cx = -junction.getFirstPipeDiameter();
        return new Point(cx, cy);
    }

    private Point getNewPointD(Point newPointC, Double deltaX, Double deltaY) {
        return new Point(newPointC.getxCoord() + deltaX, newPointC.getyCoord() + deltaY);
    }

    private Double getAxDistanceFromCorner(Point pointA, Junction junction) {
        return junction.getFirstPipeDiameter() + pointA.getxCoord();
    }

    private Double getSinAlpha(Double axDistanceFromCorner, Double rectangleLength) {
        return axDistanceFromCorner / rectangleLength;
    }

    private Double getCosAlpha(Double axDistanceFromCorner, Double rectangleLength) {
        Double sinAlpha = getSinAlpha(axDistanceFromCorner, rectangleLength);
        double angle = Math.asin(sinAlpha);
        return Math.cos(angle);
    }

    private Double getDeltaX(Double cosAlpha, Double rectangleWidth) {
        return rectangleWidth * cosAlpha;
    }

    private Double getDeltaY(Double sinAlpha, Double rectangleWidth) {
        return rectangleWidth * sinAlpha;
    }


}
