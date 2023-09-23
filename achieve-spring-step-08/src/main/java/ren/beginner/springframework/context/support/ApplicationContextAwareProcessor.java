package ren.beginner.springframework.context.support;

import ren.beginner.springframework.beans.BeansException;
import ren.beginner.springframework.beans.factory.ApplicationContextAware;
import ren.beginner.springframework.beans.factory.config.BeanPostProcessor;
import ren.beginner.springframework.context.ApplicationContext;

/**
 * @Created by Zhiliang
 * @Date 2023/9/23 0:04
 */
public class ApplicationContextAwareProcessor implements BeanPostProcessor {
    /**
     * 应用上下文
     */
    private final ApplicationContext applicationContext;

    public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof ApplicationContextAware) {
            ((ApplicationContextAware) bean).setApplicationContext(applicationContext);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
