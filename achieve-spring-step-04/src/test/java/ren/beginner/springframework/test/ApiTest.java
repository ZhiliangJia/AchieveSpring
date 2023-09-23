package ren.beginner.springframework.test;

import org.junit.Test;
import ren.beginner.springframework.beans.PropertyValue;
import ren.beginner.springframework.beans.PropertyValues;
import ren.beginner.springframework.beans.factory.config.BeanDefinition;
import ren.beginner.springframework.beans.factory.config.BeanReference;
import ren.beginner.springframework.beans.factory.support.DefaultListableBeanFactory;
import ren.beginner.springframework.test.bean.UserDao;
import ren.beginner.springframework.test.bean.UserService;

public class ApiTest {

    @Test
    public void testBeanFactory() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));

        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyList(new PropertyValue("uid", "10001"));
        propertyValues.addPropertyList(new PropertyValue("userDao", new BeanReference("userDao")));
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }

}
