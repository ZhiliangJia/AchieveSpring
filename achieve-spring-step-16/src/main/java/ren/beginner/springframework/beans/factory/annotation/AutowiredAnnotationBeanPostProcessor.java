package ren.beginner.springframework.beans.factory.annotation;

import cn.hutool.core.bean.BeanUtil;
import ren.beginner.springframework.beans.BeansException;
import ren.beginner.springframework.beans.PropertyValues;
import ren.beginner.springframework.beans.factory.BeanFactory;
import ren.beginner.springframework.beans.factory.BeanFactoryAware;
import ren.beginner.springframework.beans.factory.ConfigurableListableBeanFactory;
import ren.beginner.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import ren.beginner.springframework.util.ClassUtils;

import java.lang.reflect.Field;

/**
 * 处理 @Value、@Autowired，注解的 BeanPostProcessor
 *
 * @Created by Zhiliang
 * @Date 2023/10/4 16:00
 */
public class AutowiredAnnotationBeanPostProcessor implements InstantiationAwareBeanPostProcessor, BeanFactoryAware {
    /**
     * BeanFactory
     */
    private ConfigurableListableBeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = (ConfigurableListableBeanFactory) beanFactory;
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues propertyValues, Object bean, String beanName) throws BeansException {
        // 1. 处理注解 @Value
        Class<?> clazz = bean.getClass();
        clazz = ClassUtils.isCglibProxyClass(clazz) ? clazz.getSuperclass() : clazz;

        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            Value valueAnnotation = field.getAnnotation(Value.class);
            if (null != valueAnnotation) {
                String value = valueAnnotation.value();
                value = beanFactory.resolveEmbeddedValue(value);
                BeanUtil.setFieldValue(bean, field.getName(), value);
            }
        }

        // 2. 处理注解 @Autowired
        for (Field field : declaredFields) {
            Autowired autowiredAnnotation = field.getAnnotation(Autowired.class);
            if (null != autowiredAnnotation) {
                Class<?> fieldType = field.getType();
                String dependentBeanName = null;
                Qualifier qualifierAnnotation = field.getAnnotation(Qualifier.class);
                Object dependentBean = null;

                if (null != qualifierAnnotation) {
                    dependentBeanName = qualifierAnnotation.value();
                    dependentBean = beanFactory.getBean(dependentBeanName, fieldType);
                } else {
                    dependentBean = beanFactory.getBean(fieldType);
                }
                BeanUtil.setFieldValue(bean, field.getName(), dependentBean);
            }
        }

        return propertyValues;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        // Bug: 返回null会影响代理对象的创建
        return true;
    }
}

