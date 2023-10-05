package ren.beginner.springframework.beans.factory;

import ren.beginner.springframework.beans.BeansException;

/**
 * 定义一个工厂，该工厂可以在调用时返回对象实例（可能共享或独立）。
 *
 * @Created by Zhiliang
 * @Date 2023/10/4 23:52
 */
public interface ObjectFactory<T> {
    /**
     * 获取对象
     *
     * @return
     * @throws BeansException
     */
    T getObject() throws BeansException;
}
