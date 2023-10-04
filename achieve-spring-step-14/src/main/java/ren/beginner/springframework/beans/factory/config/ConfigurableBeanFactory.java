package ren.beginner.springframework.beans.factory.config;

import ren.beginner.springframework.beans.factory.HierarchicalBeanFactory;
import ren.beginner.springframework.util.StringValueResolver;

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

    /**
     * 为嵌入式值（例如注释属性）添加字符串解析器。
     *
     * @param valueResolver
     */
    void addEmbeddedValueResolver(StringValueResolver valueResolver);

    /**
     * 解析给定的内嵌值，例如注释属性。
     *
     * @param value
     * @return
     */
    String resolveEmbeddedValue(String value);
}
