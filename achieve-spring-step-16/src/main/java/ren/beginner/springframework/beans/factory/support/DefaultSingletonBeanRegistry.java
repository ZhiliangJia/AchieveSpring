package ren.beginner.springframework.beans.factory.support;

import ren.beginner.springframework.beans.BeansException;
import ren.beginner.springframework.beans.factory.DisposableBean;
import ren.beginner.springframework.beans.factory.ObjectFactory;
import ren.beginner.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 共享bean实例的通用注册表，实现{@linkorg.springframework.beans.factory.config.SingletonBeanRegistry}。
 * 允许注册应该为注册表的所有调用方共享的singleton实例，这些实例可以通过bean名称获得。
 *
 * @Created by Zhiliang
 * @Date 2023/9/21 15:36
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
    /**
     * 空对象
     */
    protected static final Object NULL_OBJECT = new Object();
    /**
     * 一级缓存：普通对象
     */
    private Map<String, Object> singletonObjects = new ConcurrentHashMap<>();
    /**
     * 二级缓存：没有完全实例化的对象
     */
    protected final Map<String, Object> earlySingletonObjects = new ConcurrentHashMap<>();
    /**
     * 三级缓存：存放代理对象
     */
    protected final Map<String, ObjectFactory<?>> singletonFactories = new ConcurrentHashMap<>();
    /**
     * 销毁Bean容器
     */
    private final Map<String, DisposableBean> disposableBeans = new ConcurrentHashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        Object singletonObject = singletonObjects.get(beanName);
        if (null == singletonObject) {
            singletonObject = earlySingletonObjects.get(beanName);
            // 判断二级缓存中是否有对象，这个对象就是代理对象，因为只有代理对象才会放到三级缓存中
            if (null == singletonObject) {
                ObjectFactory<?> singletonFactory = singletonFactories.get(beanName);
                if (singletonFactory != null) {
                    singletonObject = singletonFactory.getObject();
                    // 把三级缓存中的代理对象中的真实对象获取出来，放入二级缓存中
                    earlySingletonObjects.put(beanName, singletonObject);
                    singletonFactories.remove(beanName);
                }
            }
        }
        return singletonObject;
    }

    @Override
    public void registerSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
        earlySingletonObjects.remove(beanName);
        singletonFactories.remove(beanName);
    }

    protected void addSingletonFactory(String beanName, ObjectFactory<?> singletonFactory) {
        if (!this.singletonObjects.containsKey(beanName)) {
            this.singletonFactories.put(beanName, singletonFactory);
            this.earlySingletonObjects.remove(beanName);
        }
    }

    public void registerDisposableBean(String beanName, DisposableBean bean) {
        disposableBeans.put(beanName, bean);
    }

    public void destroySingletons() {
        Set<String> keySet = this.disposableBeans.keySet();
        Object[] disposableBeanNames = keySet.toArray();

        for (int i = disposableBeanNames.length - 1; i >= 0; i--) {
            Object beanName = disposableBeanNames[i];
            DisposableBean disposableBean = disposableBeans.remove(beanName);
            try {
                disposableBean.destroy();
            } catch (Exception e) {
                throw new BeansException("Destroy method on bean with name '" + beanName + "' threw an exception", e);
            }
        }
    }
}
