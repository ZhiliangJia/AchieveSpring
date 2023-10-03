package ren.beginner.springframework.beans.factory;

/**
 * 实现此接口，能感知到所属的 ClassLoader
 *
 * @Created by Zhiliang
 * @Date 2023/9/22 23:54
 */
public interface BeanClassLoaderAware extends Aware {
    /**
     * 设置ClassLoader
     *
     * @param classLoader
     */
    void setBeanClassLoader(ClassLoader classLoader);
}
