package ren.beginner.springframework.test.common;

import ren.beginner.springframework.beans.BeansException;
import ren.beginner.springframework.beans.PropertyValue;
import ren.beginner.springframework.beans.PropertyValues;
import ren.beginner.springframework.beans.factory.ConfigurableListableBeanFactory;
import ren.beginner.springframework.beans.factory.config.BeanDefinition;
import ren.beginner.springframework.beans.factory.config.BeanFactoryPostProcessor;

/**
 * @Created by Zhiliang
 * @Date 2023/9/22 11:27
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();

        propertyValues.addPropertyList(new PropertyValue("company", "改为：初学者"));
    }
}
