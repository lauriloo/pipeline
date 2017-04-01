package ee.meriloo.toru.service;

import ee.meriloo.toru.asjad.Rectangle;
import org.springframework.stereotype.Service;

/**
 * Created by Lauri on 31.03.2017.
 */
@Service
public class ristkylikService {

    public Rectangle buildRistkylik(Long pikkus, Long laius) {
        Rectangle rectangle;
        if (pikkus > laius) {
            rectangle = new Rectangle(pikkus, laius);
        } else {
            rectangle = new Rectangle(laius, pikkus);
        }
    }



}
