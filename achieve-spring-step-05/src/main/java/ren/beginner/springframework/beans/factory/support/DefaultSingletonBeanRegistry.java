package ren.beginner.springframework.beans.factory.support;

import ren.beginner.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 共享bean实例的通用注册表，实现{@linkorg.springframework.beans.factory.config.SingletonBeanRegistry}。
 * 允许注册应该为注册表的所有调用方共享的singleton实例，这些实例可以通过bean名称获得。
 *
 * @Created by Zhiliang
 * @Date 2023/9/21 15:36
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private Map<String, Object> singletonObjects = new ConcurrentHashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    protected void addSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }
}
