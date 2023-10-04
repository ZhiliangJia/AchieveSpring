package ren.beginner.springframework.beans.factory.config;

import ren.beginner.springframework.beans.BeansException;
import ren.beginner.springframework.beans.factory.ConfigurableListableBeanFactory;

/**
 * 工厂钩子，允许自定义修改应用程序上下文的bean定义，适应上下文底层bean工厂的bean属性值。
 *
 * @Created by Zhiliang
 * @Date 2023/9/21 15:34
 */
public interface BeanFactoryPostProcessor {

    /**
     * 在所有的 BeanDefinition 加载完成后，实例化 Bean 对象之前，提供修改 BeanDefinition 属性的机制
     *
     * @param beanFactory
     * @throws BeansException
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
