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

    /**
     * 检查指定的类是否为cglib生成的类。
     *
     * @param clazz
     * @return
     */
    public static boolean isCglibProxyClass(Class<?> clazz) {
        return (clazz != null && isCglibProxyClassName(clazz.getName()));
    }

    /**
     * 检查指定的类名是否为cglib生成的类。
     *
     * @param className
     * @return
     */
    public static boolean isCglibProxyClassName(String className) {
        return (className != null && className.contains("$$"));
    }
}
