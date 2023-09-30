package ren.beginner.springframework.beans.factory.config;

import ren.beginner.springframework.beans.factory.HierarchicalBeanFactory;

/**
 * 大多数bean工厂要实现的配置接口。除了{@link-org.springframework.beans.factory.BeanFactory}接口
 * 中的bean工厂客户机方法外，还提供配置bean工厂的工具。
 *
 * @Created by Zhiliang
 * @Date 2023/9/21 15:36
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {
    /**
     * 单例Bean
     */
    String SCOPE_SINGLETON = "singleton";
    /**
     * 多例Bean
     */
    String SCOPE_PROTOTYPE = "prototype";

    /**
     * 添加Bean的后置处理
     *
     * @param beanPostProcessor
     */
    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

    /**
     * 单例对象的销毁
     */
    void destroySingletons();
}
