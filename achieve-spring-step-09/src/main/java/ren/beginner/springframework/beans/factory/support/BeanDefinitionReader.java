package ren.beginner.springframework.beans.factory.support;

import ren.beginner.springframework.beans.BeansException;
import ren.beginner.springframework.core.io.Resource;
import ren.beginner.springframework.core.io.ResourceLoader;

/**
 * bean定义读取器的简单接口。使用资源和字符串位置参数指定加载方法。
 *
 * @Created by Zhiliang
 * @Date 2023/9/21 15:36
 */
public interface BeanDefinitionReader {

    /**
     * 获取BeanDefinition的读取器
     *
     * @return
     */
    BeanDefinitionRegistry getRegistry();

    /**
     * 获取资源目录
     *
     * @return
     */
    ResourceLoader getResourceLoader();

    /**
     * 加载BeanDefinition
     *
     * @param resource
     * @throws BeansException
     */
    void loadBeanDefinitions(Resource resource) throws BeansException;

    /**
     * 加载BeanDefinition
     *
     * @param resources
     * @throws BeansException
     */
    void loadBeanDefinitions(Resource... resources) throws BeansException;

    /**
     * 加载BeanDefinition
     *
     * @param location
     * @throws BeansException
     */
    void loadBeanDefinitions(String location) throws BeansException;

    /**
     * 从多个location加载BeanDefinition
     *
     * @param locations
     * @throws BeansException
     */
    void loadBeanDefinitions(String... locations) throws BeansException;
}
