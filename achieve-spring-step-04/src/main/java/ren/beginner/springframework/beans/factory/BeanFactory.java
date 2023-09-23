package ren.beginner.springframework.beans.factory;

import ren.beginner.springframework.beans.BeansException;

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
}
