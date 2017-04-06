package ee.meriloo.toru.service;

import ee.meriloo.toru.model.Point;
import ee.meriloo.toru.model.Rectangle;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class RectangleMovingServiceHelper {

    private static final double ZERO = 0.0;

    public Point buildLeftDown() {
        return new Point(BigDecimal.valueOf(ZERO), BigDecimal.valueOf(ZERO));
    }

    public Point buildRightDown(Rectangle rectangle) {
        return new Point(rectangle.getWidth(), BigDecimal.valueOf(ZERO));
    }

    public Point buildLeftUp(Rectangle rectangle) {
        return new Point(BigDecimal.valueOf(ZERO), rectangle.getLength());
    }
    public Point buildRightUp(Rectangle rectangle) {
        return new Point(rectangle.getWidth(), rectangle.getLength());
    }

    public Point buildLeftDownTurned() {
        return buildLeftDown();
    }

    public Point buildRightDownTurned(Rectangle rectangle) {
        return new Point(rectangle.getLength(), BigDecimal.valueOf(ZERO));
    }

    public Point buildLeftUpTurned(Rectangle rectangle) {
        return new Point(BigDecimal.valueOf(ZERO), rectangle.getWidth());
    }
    public Point buildRightUpTurned(Rectangle rectangle) {
        return new Point(rectangle.getLength(), rectangle.getWidth());
    }

    public void moveLeft(Rectangle rectangle, BigDecimal left) {
        moveLeft(rectangle.getLeftDownCornerA(), left);
        moveLeft(rectangle.getRightDownCornerB(), left);
        moveLeft(rectangle.getLeftUpCornerC(), left);
        moveLeft(rectangle.getRightUpCornerD(), left);
    }

    public void moveDown(Rectangle rectangle, BigDecimal down) {
        moveDown(rectangle.getLeftDownCornerA(), down);
        moveDown(rectangle.getRightDownCornerB(), down);
        moveDown(rectangle.getLeftUpCornerC(), down);
        moveDown(rectangle.getRightUpCornerD(), down);
    }

    public void moveLeft(Point point, BigDecimal left) {
        point.setxCoord(point.getxCoord().subtract(left));
    }

    public void moveDown(Point point, BigDecimal down) {
        point.setyCoord(point.getyCoord().subtract(down));
    }
}
