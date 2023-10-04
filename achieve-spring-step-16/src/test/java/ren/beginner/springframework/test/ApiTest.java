package ren.beginner.springframework.test;

import org.junit.Test;
import ren.beginner.springframework.context.support.ClassPathXmlApplicationContext;
import ren.beginner.springframework.test.bean.IUserService;
import ren.beginner.springframework.test.bean2.IUserService2;

/**
 * @Created by Zhiliang
 * @Date 2023/10/4 22:32
 */
public class ApiTest {

    @Test
    public void testAutoProxy() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        System.out.println("测试结果" + userService.queryUserInfo());
    }

    @Test
    public void testAutoProxy2() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring2.xml");
        IUserService2 userService = applicationContext.getBean("userService2", IUserService2.class);
        System.out.println("测试结果：" + userService.queryUserInfo());
    }
}
