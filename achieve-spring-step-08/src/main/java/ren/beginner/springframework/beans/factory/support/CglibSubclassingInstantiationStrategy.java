package ren.beginner.springframework.beans.factory.support;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import ren.beginner.springframework.beans.BeansException;
import ren.beginner.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * 使用Cglib完成Bean对象的创建
 *
 * @Created by Zhiliang
 * @Date 2023/9/21 15:36
 */
public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy {
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(beanDefinition.getBeanClass());
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        if (null == ctor) {
            return enhancer.create();
        }
        return enhancer.create(ctor.getParameterTypes(), args);
    }
}
