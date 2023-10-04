package ren.beginner.springframework.beans.factory.config;

import ren.beginner.springframework.beans.BeansException;
import ren.beginner.springframework.beans.factory.BeanFactory;

/**
 * {@link-org.springframework.beans.factory.BeanFactory}接口的扩展将由能够自动连接
 * 的bean工厂实现，前提是它们希望为现有bean实例公开此功能。
 *
 * @Created by Zhiliang
 * @Date 2023/9/21 12:13
 */
public interface AutowireCapableBeanFactory extends BeanFactory {
    /**
     * 执行 BeanPostProcessors 接口实现类的 postProcessBeforeInitialization 方法
     *
     * @param existingBean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException;

    /**
     * 执行 BeanPostProcessors 接口实现类的 postProcessorsAfterInitialization 方法
     *
     * @param existingBean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException;
}
