package ee.meriloo.toru.service;

import ee.meriloo.toru.model.Junction;
import ee.meriloo.toru.model.Rectangle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class RectangleMovingService {

    @Autowired
    private RectangleMovingServiceHelper rectangleMovingServiceHelper;

    public void moveToCoordZero(Rectangle rectangle) {
        rectangle.setLeftDownCornerA(rectangleMovingServiceHelper.buildLeftDown(rectangle));
        rectangle.setRightDownCornerB(rectangleMovingServiceHelper.buildRightDown(rectangle));
        rectangle.setLeftUpCornerC(rectangleMovingServiceHelper.buildLeftUp(rectangle));
        rectangle.setRightUpCornerD(rectangleMovingServiceHelper.buildRightUp(rectangle));
    }

    public void moveToJunctionCorner(Rectangle rectangle, Junction junction) {
        moveToCoordZero(rectangle);
        BigDecimal firstPipeDiameter = junction.getFirstPipeDiameter();
        BigDecimal secondPipeDiameter = junction.getSecondPipeDiameter();
        rectangleMovingServiceHelper.moveLeft(rectangle, firstPipeDiameter);
        rectangleMovingServiceHelper.moveDown(rectangle, secondPipeDiameter);
    }





}
