package ren.beginner.springframework.beans.factory.support;

import ren.beginner.springframework.beans.BeansException;
import ren.beginner.springframework.beans.factory.config.BeanDefinition;
import ren.beginner.springframework.beans.factory.config.BeanPostProcessor;
import ren.beginner.springframework.beans.factory.config.ConfigurableBeanFactory;
import ren.beginner.springframework.utils.ClassUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link-org.springframework.beans.factory.BeanFactory}实现的抽象基类，提
 * 供了{@link-org.springframework.beans.factory.config.ConfigurableBeanFacctory}SPI的
 * 全部功能。因此也可以用作bean工厂实现的基类，这些实现从一些后端资源获得bean定义（其中bean定义访问是一个昂贵的操作）。
 *
 * @Created by Zhiliang
 * @Date 2023/9/21 15:36
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements ConfigurableBeanFactory {
    /**
     * 默认的ClassLoader
     */
    private ClassLoader beanClassLoader = ClassUtils.getDefaultClassLoader();
    /**
     * BeanPostProcessor列表
     */
    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();

    @Override
    public Object getBean(String name) {
        return doGetBean(name, null);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return doGetBean(name, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return (T) getBean(name);
    }

    protected <T> T doGetBean(final String name, final Object[] args) {
        Object bean = getSingleton(name);
        if (bean != null) {
            return (T) bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return (T) createBean(name, beanDefinition, args);
    }

    /**
     * 获取BeanDefinition
     *
     * @param beanName
     * @return
     * @throws BeansException
     */
    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * 创建Bean对象
     *
     * @param beanName
     * @param beanDefinition
     * @param args
     * @return
     * @throws BeansException
     */
    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException;

    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        this.beanPostProcessors.remove(beanPostProcessor);
        this.beanPostProcessors.add(beanPostProcessor);
    }

    public List<BeanPostProcessor> getBeanPostProcessors() {
        return beanPostProcessors;
    }

    public ClassLoader getBeanClassLoader() {
        return this.beanClassLoader;
    }
}
