package ren.beginner.springframework.test;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
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

        UserService userService = (UserService) beanFactory.getBean("userService", "Jzl");
        userService.queryUserInfo();
    }

    @Test
    public void testCglib() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserService.class);
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        Object obj = enhancer.create(new Class[]{String.class}, new Object[]{"Jzl"});
        System.out.println(obj);
    }

}
