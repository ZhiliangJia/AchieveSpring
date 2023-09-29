package ren.beginner.springframework.beans.factory;

/**
 * 接口将由{@link BeanFactory}中使用的对象实现，这些对象本身就是单个对象的工厂。如果一个bean实现了这个接口，它将被用作要公开的对象的工厂，而不是直接作为将要公开自己的bean实例。
 *
 * @Created by Zhiliang
 * @Date 2023/9/29 19:55
 */
public interface FactoryBean<T> {
    /**
     * 返回由该工厂管理的对象的实例(可能是共享的或独立的)。
     *
     * @return
     * @throws Exception
     */
    T getObject() throws Exception;

    /**
     * 返回此FactoryBean创建的对象类型，如果事先不知道，则返回{@code null}。
     *
     * @return
     */
    Class<?> getObjectType();

    /**
     * 这个工厂管理的对象是单例的吗?也就是说，{@link #getObject()}是否总是返回相同的对象(可以缓存的引用)?
     *
     * @return
     */
    boolean isSingleton();
}
