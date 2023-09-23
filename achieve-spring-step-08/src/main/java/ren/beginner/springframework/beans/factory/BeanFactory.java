package ren.beginner.springframework.beans.factory;

import ren.beginner.springframework.beans.BeansException;

/**
 * BeanFactory是Spring框架的核心容器接口之一，它的主要作用是管理和提供Bean实例。
 *
 * @Created by Zhiliang
 * @Date 2023/9/21 15:36
 */
public interface BeanFactory {
    /**
     * 生成无参的构造方法
     *
     * @param name
     * @return
     * @throws BeansException
     */
    Object getBean(String name) throws BeansException;

    /**
     * 生成有参的构造方法
     *
     * @param name
     * @param args
     * @return
     * @throws BeansException
     */
    Object getBean(String name, Object... args) throws BeansException;

    /**
     * 获取类型转化后的Bean
     *
     * @param name
     * @param requiredType
     * @param <T>
     * @return
     * @throws BeansException
     */
    <T> T getBean(String name, Class<T> requiredType) throws BeansException;
}

