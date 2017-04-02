package ee.meriloo.toru.service;

import ee.meriloo.toru.model.Point;
import ee.meriloo.toru.model.Rectangle;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class RectangleMovingServiceHelper {

    public Point buildLeftDown(Rectangle rectangle) {
        return new Point(BigDecimal.valueOf(0d), BigDecimal.valueOf(0d));
    }

    public Point buildRightDown(Rectangle rectangle) {
        return new Point(rectangle.getWidth(), BigDecimal.valueOf(0d));
    }

    public Point buildLeftUp(Rectangle rectangle) {
        return new Point(BigDecimal.valueOf(0d), rectangle.getLength());
    }
    public Point buildRightUp(Rectangle rectangle) {
        return new Point(rectangle.getWidth(), rectangle.getLength());
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

    public void moveRight(Point point, BigDecimal right) {
        point.setxCoord(point.getxCoord().add(right));
    }

    public void moveDown(Point point, BigDecimal down) {
        point.setyCoord(point.getyCoord().subtract(down));
    }

    public void moveUp(Point point, BigDecimal up) {
        point.setyCoord(point.getyCoord().add(up));
    }

}
