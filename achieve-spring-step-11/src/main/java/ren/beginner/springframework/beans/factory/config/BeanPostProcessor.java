package ren.beginner.springframework.beans.factory.config;

import ren.beginner.springframework.beans.BeansException;

/**
 * 允许自定义修改新bean实例的工厂挂钩，例如，检查标记接口或用代理包装bean。
 *
 * @Created by Zhiliang
 * @Date 2023/9/21 15:36
 */
public interface BeanPostProcessor {

    /**
     * 在Bean对象执行初始化方法之前，执行此方法
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;

    /**
     * 在Bean对象执行初始化方法之后，执行此方法
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;

}
