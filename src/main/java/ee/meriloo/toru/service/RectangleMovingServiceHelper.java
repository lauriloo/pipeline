package ee.meriloo.toru.service;

import ee.meriloo.toru.model.Point;
import ee.meriloo.toru.model.Rectangle;
import org.springframework.stereotype.Service;

@Service
public class RectangleMovingServiceHelper {

    public Point buildLeftDown(Rectangle rectangle) {
        return new Point(0d, 0d);
    }

    public Point buildRightDown(Rectangle rectangle) {
        return new Point(rectangle.getWidth(), 0d);
    }

    public Point buildLeftUp(Rectangle rectangle) {
        return new Point(0d, rectangle.getLength());
    }
    public Point buildRightUp(Rectangle rectangle) {
        return new Point(rectangle.getWidth(), rectangle.getLength());
    }

    public void moveLeft(Rectangle rectangle, Double left) {
        moveLeft(rectangle.getLeftDownCornerA(), left);
        moveLeft(rectangle.getRightDownCornerB(), left);
        moveLeft(rectangle.getLeftUpCornerC(), left);
        moveLeft(rectangle.getRightUpCornerD(), left);
    }

    public void moveDown(Rectangle rectangle, Double down) {
        moveDown(rectangle.getLeftDownCornerA(), down);
        moveDown(rectangle.getRightDownCornerB(), down);
        moveDown(rectangle.getLeftUpCornerC(), down);
        moveDown(rectangle.getRightUpCornerD(), down);
    }

    public void moveLeft(Point point, Double left) {
        point.setxCoord(point.getxCoord() - left);
    }

    public void moveRight(Point point, Double right) {
        point.setxCoord(point.getxCoord() + right);
    }

    public void moveDown(Point point, Double down) {
        point.setyCoord(point.getyCoord() - down);
    }

    public void moveUp(Point point, Double up) {
        point.setyCoord(point.getyCoord() + up);
    }

    //public void turnLeftDownA(Point, )
}
