package edu.mareanexx;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestLighter {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(LighterConfig.class);
        Lighter lighter = context.getBean("Firefly", Lighter.class);
        System.out.println("What makes light:" + lighter.doLight());
    }
}
