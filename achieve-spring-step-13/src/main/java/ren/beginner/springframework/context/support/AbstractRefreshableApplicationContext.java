package ren.beginner.springframework.context.support;

import ren.beginner.springframework.beans.BeansException;
import ren.beginner.springframework.beans.factory.ConfigurableListableBeanFactory;
import ren.beginner.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * ｛@link cn.bugstack.springframework.context.ApplicationContext｝实现的基类，这
 * 些实现应该支持对｛@link#refresh（）｝的多次调用，每次都创建一个新的内部bean工厂实例。通常
 * （但不一定），这样的上下文将由一组从中加载bean定义的配置位置驱动。
 *
 * @Created by Zhiliang
 * @Date 2023/9/22 11:09
 */
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext {
    /**
     * BeanFactory
     */
    private DefaultListableBeanFactory beanFactory;

    @Override
    protected void refreshBeanFactory() throws BeansException {
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
    }

    private DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }

    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);

    @Override
    protected ConfigurableListableBeanFactory getBeanFactory() {
        return beanFactory;
    }
}
