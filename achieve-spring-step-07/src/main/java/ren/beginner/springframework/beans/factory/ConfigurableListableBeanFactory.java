package ren.beginner.springframework.beans.factory;

import ren.beginner.springframework.beans.BeansException;
import ren.beginner.springframework.beans.factory.config.AutowireCapableBeanFactory;
import ren.beginner.springframework.beans.factory.config.BeanDefinition;
import ren.beginner.springframework.beans.factory.config.ConfigurableBeanFactory;

/**
 * 配置接口将由大多数可列出的bean工厂实现。除了{@linkConfigurationBeanFactory}之外，它还提供了分析
 * 和修改bean定义以及预实例化singleton的工具。
 *
 * @Created by Zhiliang
 * @Date 2023/9/21 15:36
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    /**
     * 获取对应bean的BeanDefinition
     *
     * @param beanName
     * @return
     * @throws BeansException
     */
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * 提前实例化单例Bean对象
     *
     * @throws BeansException
     */
    void preInstantiateSingletons() throws BeansException;

}
