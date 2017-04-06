package ee.meriloo.toru;

import ee.meriloo.toru.service.MainService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * programmi testimiseks kirjuta sisendandmed INPUT stringi ja käivita main meetod.
 */
public class Main {

    private static final String INPUT = "60, 120, 100, 75";
//    private static final String INPUT = "100, 35, 75, 50, 80, 100, 37";
//    private static final String INPUT = "70, 50, 60, 60, 55, 90";

//    private static final String INPUT = "40, 40, 100, 40";
//    private static final String INPUT = "40, 40, 100, 39";
//    private static final String INPUT = "40, 40, 40, 40";


    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        MainService mainService = context.getBean(MainService.class);
        mainService.buildAndTestPipeline(INPUT);
    }

}
