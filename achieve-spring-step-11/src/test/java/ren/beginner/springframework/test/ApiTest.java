package ren.beginner.springframework.test;

import org.junit.Test;
import ren.beginner.springframework.context.support.ClassPathXmlApplicationContext;
import ren.beginner.springframework.test.event.CustomEvent;

public class ApiTest {

    @Test
    public void testEvent() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.publishEvent(new CustomEvent(applicationContext, 1019129009086763L, "成功了！"));

        applicationContext.registerShutdownHook();
    }
}
