package ren.beginner.springframework.beans.factory.config;

import ren.beginner.springframework.beans.PropertyValues;

/**
 * BeanDefinition描述bean实例，该实例具有属性值、构造函数参数值和由具体实现提供的进一步信息。
 *
 * @Created by Zhiliang
 * @Date 2023/9/21 12:13
 */
public class BeanDefinition {
    String SCOPE_SINGLETON = ConfigurableBeanFactory.SCOPE_SINGLETON;
    String SCOPE_PROTOTYPE = ConfigurableBeanFactory.SCOPE_PROTOTYPE;
    /**
     * bean对应的class
     */
    private Class beanClass;
    /**
     * bean对应的属性值
     */
    private PropertyValues propertyValues;
    /**
     * 属性注入结束之后执行的方法
     */
    private String initMethodName;
    /**
     * 销毁执行的方法
     */
    private String destroyMethodName;
    /**
     * 对象作用域
     */
    private String scope = SCOPE_SINGLETON;
    /**
     * 是否为单例对象
     */
    private boolean singleton = true;
    /**
     * 是否为实例对象
     */
    private boolean prototype = false;

    public BeanDefinition(Class beanClass) {
        this(beanClass, null);
    }

    public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues != null ? propertyValues : new PropertyValues();
    }

    public void setScope(String scope) {
        this.scope = scope;
        singleton = SCOPE_SINGLETON.equals(scope);
        prototype = SCOPE_PROTOTYPE.equals(scope);
    }

    public boolean isSingleton() {
        return singleton;
    }

    public boolean isPrototype() {
        return prototype;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }

    public String getInitMethodName() {
        return initMethodName;
    }

    public void setInitMethodName(String initMethodName) {
        this.initMethodName = initMethodName;
    }

    public String getDestroyMethodName() {
        return destroyMethodName;
    }

    public void setDestroyMethodName(String destroyMethodName) {
        this.destroyMethodName = destroyMethodName;
    }
}
