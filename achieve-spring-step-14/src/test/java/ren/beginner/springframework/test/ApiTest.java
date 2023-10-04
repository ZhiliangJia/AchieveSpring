package ren.beginner.springframework.test;

import org.junit.Test;
import ren.beginner.springframework.context.support.ClassPathXmlApplicationContext;
import ren.beginner.springframework.test.bean.IUserService;

public class ApiTest {

    @Test
    public void testProperty() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-property.xml");
        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        System.out.println("测试结果：" + userService);
    }

    @Test
    public void testScan() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-scan.xml");
        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        System.out.println("测试结果" + userService.queryUserInfo());
    }
}
