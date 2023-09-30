package ren.beginner.springframework.beans.factory.support;

import cn.hutool.core.util.StrUtil;
import ren.beginner.springframework.beans.BeansException;
import ren.beginner.springframework.beans.factory.DisposableBean;
import ren.beginner.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Method;

/**
 * 实现{@link DisposableBean}和{@link Runnable}接口的适配器，在给定的bean实例上执行各种销毁步骤：
 * 1. DestructionAwareBeanPostProcessors
 * 2. 实现了DisposableBean的bean
 * 3. 在bean定义上指定的自定义销毁方法
 *
 * @Created by Zhiliang
 * @Date 2023/9/22 16:54
 */
public class DisposableBeanAdapter implements DisposableBean {

    /**
     * 销毁的Bean对象
     */
    private final Object bean;
    /**
     * 销毁Bean的名称
     */
    private final String beanName;
    /**
     * 执行销毁的方法名
     */
    private final String destroyMethodName;

    public DisposableBeanAdapter(Object bean, String beanName, BeanDefinition beanDefinition) {
        this.bean = bean;
        this.beanName = beanName;
        this.destroyMethodName = beanDefinition.getDestroyMethodName();
    }

    @Override
    public void destroy() throws Exception {
        // 1. 实现接口 DisposableBean
        if (bean instanceof DisposableBean) {
            ((DisposableBean) bean).destroy();
        }

        // 2. 注解配置 destroy-method {判断是为了避免二次执行销毁}
        if (StrUtil.isNotEmpty(destroyMethodName) && !(bean instanceof DisposableBean && "destroy".equals(this.destroyMethodName))) {
            Method destroyMethod = bean.getClass().getMethod(destroyMethodName);
            if (null == destroyMethod) {
                throw new BeansException("Couldn't find a destroy method named '" + destroyMethodName + "' on bean with name '" + beanName + "'");
            }
            destroyMethod.invoke(bean);
        }
    }
}
