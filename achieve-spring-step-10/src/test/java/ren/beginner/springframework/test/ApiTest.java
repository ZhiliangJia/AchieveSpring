package ren.beginner.springframework.test;

import com.alibaba.fastjson2.JSON;
import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;
import ren.beginner.springframework.context.support.ClassPathXmlApplicationContext;
import ren.beginner.springframework.test.bean.UserService;

public class ApiTest {

    @Test
    public void testBeanFactory() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();
        // 2. 调用代理方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        System.out.println("测试结果：" + userService.queryUserInfo());
    }

    @Test
    public void testBeanPrototype() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();

        UserService userService1 = applicationContext.getBean("userService", UserService.class);
        UserService userService2 = applicationContext.getBean("userService", UserService.class);

        System.out.println(userService1);
        System.out.println(userService2);

        System.out.println(userService1 + " 十六进制哈希：" + Integer.toHexString(userService1.hashCode()));
        System.out.println(ClassLayout.parseInstance(userService1).toPrintable());
        System.out.println(userService1.hashCode());
        System.out.println(userService2.hashCode());
    }
}
