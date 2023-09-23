package ren.beginner.springframework.beans.factory.support;

import ren.beginner.springframework.beans.BeansException;
import ren.beginner.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * 负责创建与根bean定义对应的实例的接口
 *
 * @Created by Zhiliang
 * @Date 2023/9/21 15:36
 */
public interface InstantiationStrategy {
    /**
     * 根据构造函数和入参生成实例化对象
     *
     * @param beanDefinition
     * @param beanName
     * @param ctor
     * @param args
     * @return
     * @throws BeansException
     */
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException;
}
