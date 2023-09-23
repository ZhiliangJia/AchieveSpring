package ren.beginner.springframework.beans.factory.support;

import ren.beginner.springframework.beans.BeansException;
import ren.beginner.springframework.beans.factory.BeanFactory;
import ren.beginner.springframework.beans.factory.config.BeanDefinition;

public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
    @Override
    public Object getBean(String name) {
        Object bean = getSingleton(name);
        if (bean != null) return bean;
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name, beanDefinition);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;
}
