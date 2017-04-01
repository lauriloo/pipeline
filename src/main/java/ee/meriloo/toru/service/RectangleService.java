package ee.meriloo.toru.service;

import ee.meriloo.toru.model.Rectangle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RectangleService {

    @Autowired
    private RectangleServiceHelper rectangleServiceHelper;

    public void initCoordinates(Rectangle rectangle) {
        rectangle.setLeftDownCornerA(rectangleServiceHelper.buildLeftDown(rectangle));
        rectangle.setRightDownCornerB(rectangleServiceHelper.buildRightDown(rectangle));
        rectangle.setLeftUpCornerC(rectangleServiceHelper.buildLeftUp(rectangle));
        rectangle.setRightUpCornerD(rectangleServiceHelper.buildRightUp(rectangle));
    }



}
