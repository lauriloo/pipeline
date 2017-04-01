package ee.meriloo.toru.service;

import ee.meriloo.toru.model.Rectangle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RectangleBuilder {

    @Autowired
    RectangleService rectangleService;

//    public Rectangle buildRectangle(Double oneSide, Double theOtherSide) {
//        Rectangle rectangle = baseBuild(oneSide, theOtherSide);
//        rectangleService.initCoordinates(rectangle);
//        return rectangle;
//    }

    public Rectangle buildRectangle(List<Double> dimensions) {
        Rectangle rectangle = baseBuild(dimensions.get(0), dimensions.get(1));
        rectangleService.initCoordinates(rectangle);
        return rectangle;
    }

    private Rectangle baseBuild(Double oneSide, Double theOtherSide) {
        return oneSide > theOtherSide ? new Rectangle(oneSide, theOtherSide) : new Rectangle(theOtherSide, oneSide);
    }

}