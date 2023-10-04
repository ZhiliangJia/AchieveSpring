package ren.beginner.springframework.beans.factory.config;

import ren.beginner.springframework.beans.BeansException;
import ren.beginner.springframework.beans.PropertyValues;

/**
 * ｛@link BeanPostProcessor｝的子接口，它添加了实例化前的回调和实例化后但在设置显式属性或发生自动连接之前的回调。
 *
 * @Created by Zhiliang
 * @Date 2023/10/1 23:04
 */
public interface InstantiationAwareBeanPostProcessor extends BeanPostProcessor {
    /**
     * 在目标bean被实例化之前应用这个BeanPostProcessor＜i＞。返回的bean对象可能是要使用的代理，
     * 而不是目标bean，从而有效地抑制了目标bean的默认实例化。
     *
     * @param beanClass
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException;

    /**
     * 在 Bean 对象执行初始化方法之后，执行此方法
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException;

    /**
     * 在 Bean 对象实例化完成后，设置属性操作之前执行此方法
     *
     * @param propertyValues
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    PropertyValues postProcessPropertyValues(PropertyValues propertyValues, Object bean, String beanName) throws BeansException;
}
