package ren.beginner.springframework.beans.factory.support;

import ren.beginner.springframework.core.io.DefaultResourceLoader;
import ren.beginner.springframework.core.io.ResourceLoader;

/**
 * 实现{@linkBeanDefinitionReader}接口的bean定义读取器的抽象基类。
 *
 * @Created by Zhiliang
 * @Date 2023/9/21 15:36
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {
    /**
     * BeanDefinition的注册器
     */
    private final BeanDefinitionRegistry registry;
    /**
     * 资源加载器
     */
    private ResourceLoader resourceLoader;

    protected AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this(registry, new DefaultResourceLoader());
    }

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        this.registry = registry;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
