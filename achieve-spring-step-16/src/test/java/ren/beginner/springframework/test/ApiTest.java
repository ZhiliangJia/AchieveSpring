package ren.beginner.springframework.test;

import org.junit.Test;
import ren.beginner.springframework.context.support.ClassPathXmlApplicationContext;
import ren.beginner.springframework.test.bean.Husband;
import ren.beginner.springframework.test.bean.Wife;

/**
 * @Created by Zhiliang
 * @Date 2023/10/4 22:32
 */
public class ApiTest {

    @Test
    public void testCircular() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        Husband husband = applicationContext.getBean("husband", Husband.class);
        Wife wife = applicationContext.getBean("wife", Wife.class);
        System.out.println("老公的媳妇：" + husband.queryWife());
        System.out.println("媳妇的老公：" + wife.queryHusband());
    }
}
