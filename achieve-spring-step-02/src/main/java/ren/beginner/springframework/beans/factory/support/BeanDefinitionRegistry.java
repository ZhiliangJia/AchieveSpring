package ren.beginner.springframework.beans.factory.support;

import ren.beginner.springframework.beans.factory.config.BeanDefinition;

public interface BeanDefinitionRegistry {
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
