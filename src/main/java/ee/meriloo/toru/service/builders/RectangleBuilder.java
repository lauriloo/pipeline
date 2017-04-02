package ee.meriloo.toru.service.builders;

import ee.meriloo.toru.model.Rectangle;
import ee.meriloo.toru.service.RectangleMovingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RectangleBuilder {

    @Autowired
    RectangleMovingService rectangleMovingService;

    public Rectangle buildRectangle(List<Double> dimensions) {
        Rectangle rectangle = baseBuild(dimensions.get(0), dimensions.get(1));
        rectangleMovingService.moveToCoordZero(rectangle);
        return rectangle;
    }

    private Rectangle baseBuild(Double oneSide, Double theOtherSide) {
        return oneSide > theOtherSide ? new Rectangle(oneSide, theOtherSide) : new Rectangle(theOtherSide, oneSide);
    }

}
