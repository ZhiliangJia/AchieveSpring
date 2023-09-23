package ren.beginner.springframework.test;

import org.junit.Test;
import ren.beginner.springframework.beans.factory.config.BeanDefinition;
import ren.beginner.springframework.beans.factory.support.DefaultListableBeanFactory;
import ren.beginner.springframework.test.bean.UserService;

public class ApiTest {

    @Test
    public void testBeanFactory() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();

        UserService userService_singleton = (UserService) beanFactory.getBean("userService");
        userService_singleton.queryUserInfo();
    }
}
