package ren.beginner.springframework.beans.factory.config;

/**
 * 为共享bean实例定义注册表的接口。可以由{@link-org.springframework.beans.factory.BeanFactory}
 * 实现，以便以统一的方式公开其单例管理工具。
 *
 * @Created by Zhiliang
 * @Date 2023/9/21 15:36
 */
public interface SingletonBeanRegistry {

    /**
     * 获取单例对象
     *
     * @param beanName
     * @return
     */
    Object getSingleton(String beanName);

    /**
     * 在bean注册中心以给定的bean名称将给定的现有对象注册为单例对象。
     *
     * @param beanName
     * @param singletonObject
     */
    void registerSingleton(String beanName, Object singletonObject);
}
