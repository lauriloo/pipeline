package ee.meriloo.toru;

import ee.meriloo.toru.asjad.Rectangle;
import ee.meriloo.toru.service.TorustikBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by Lauri on 31.03.2017.
 */
@Component
public class Main {

    @Autowired
    TorustikBuilder torustikBuilder;


    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Main main = context.getBean(Main.class);

        Rectangle esimeneRectangle = new Rectangle(60L, 100L);

    }

}
