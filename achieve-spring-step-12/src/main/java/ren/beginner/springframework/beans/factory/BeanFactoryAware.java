package ren.beginner.springframework.beans.factory;

import ren.beginner.springframework.beans.BeansException;

/**
 * 实现此接口，能感知到所属的 BeanFactory
 *
 * @Created by Zhiliang
 * @Date 2023/9/22 23:52
 */
public interface BeanFactoryAware extends Aware {
    /**
     * 设置BeanFactory
     *
     * @param beanFactory
     * @throws BeansException
     */
    void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}
