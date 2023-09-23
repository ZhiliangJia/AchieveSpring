package ren.beginner.springframework.beans.factory;

import ren.beginner.springframework.beans.BeansException;

import java.util.Map;

/**
 * ｛@link BeanFactory｝接口的扩展将由可以枚举其所有bean实例的bean工厂实现，而
 * 不是根据客户端的请求逐个尝试按名称查找bean。预加载所有bean定义的BeanFactory实
 * 现（例如基于XML的工厂）可以实现此接口。
 *
 * @Created by Zhiliang
 * @Date 2023/9/21 15:36
 */
public interface ListableBeanFactory extends BeanFactory {
    /**
     * 按照类型返回Bean实例
     *
     * @param type
     * @param <T>
     * @return
     * @throws BeansException
     */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

    /**
     * 返回注册表中所有的Bean名称
     *
     * @return
     */
    String[] getBeanDefinitionNames();
}
