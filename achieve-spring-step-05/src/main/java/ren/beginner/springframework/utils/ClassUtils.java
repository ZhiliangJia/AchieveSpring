package ren.beginner.springframework.utils;

/**
 * Class常用方法
 *
 * @Created by Zhiliang
 * @Date 2023/9/21 12:13
 */
public class ClassUtils {

    /**
     * 获取类的ClassLoader
     *
     * @return
     */
    public static ClassLoader getDefaultClassLoader() {
        ClassLoader classLoader = null;
        try {
            classLoader = Thread.currentThread().getContextClassLoader();
        } catch (Throwable e) {
            // Cannot access thread context ClassLoader - falling back to system class loader...
        }

        if (classLoader == null) {
            // No thread context class loader -> use class loader of this class.
            classLoader = ClassUtils.class.getClassLoader();
        }
        return classLoader;
    }
}
