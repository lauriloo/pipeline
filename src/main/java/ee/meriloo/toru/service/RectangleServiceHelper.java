package ee.meriloo.toru.service;

import ee.meriloo.toru.model.Point;
import ee.meriloo.toru.model.Rectangle;
import org.springframework.stereotype.Service;

@Service
public class RectangleServiceHelper {

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
}
