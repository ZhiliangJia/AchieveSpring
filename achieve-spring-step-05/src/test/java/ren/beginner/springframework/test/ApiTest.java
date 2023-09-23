package ren.beginner.springframework.test;

import org.junit.Test;
import ren.beginner.springframework.context.support.ClassPathXmlApplicationContext;
import ren.beginner.springframework.test.bean.UserService;

public class ApiTest {

    @Test
    public void testBeanFactory() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");

        UserService userService = applicationContext.getBean("userService", UserService.class);
        System.out.println(userService);
        String result = userService.queryUserInfo();
        System.out.println(result);
    }
}
