package ee.meriloo.toru.service.builders;

import ee.meriloo.toru.model.Rectangle;
import ee.meriloo.toru.service.RectangleMovingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class RectangleBuilder {

    @Autowired
    RectangleMovingService rectangleMovingService;

    public Rectangle buildRectangle(List<BigDecimal> dimensions) {
        Rectangle rectangle = baseBuild(dimensions.get(0), dimensions.get(1));
        rectangleMovingService.moveToCoordZero(rectangle);
        return rectangle;
    }

    private Rectangle baseBuild(BigDecimal oneSide, BigDecimal theOtherSide) {
        return oneSide.compareTo(theOtherSide) > 0 ? new Rectangle(oneSide, theOtherSide)
                : new Rectangle(theOtherSide, oneSide);
    }

}
