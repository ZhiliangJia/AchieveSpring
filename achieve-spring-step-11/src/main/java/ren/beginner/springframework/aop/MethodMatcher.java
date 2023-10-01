package ren.beginner.springframework.aop;

import java.lang.reflect.Method;

/**
 * {@link Pointcut}的一部分：检查目标方法是否符合通知的条件。
 *
 * @Created by Zhiliang
 * @Date 2023/9/30 22:27
 */
public interface MethodMatcher {
    /**
     * 执行静态检查以确定给定的方法是否匹配
     *
     * @param method
     * @param targetClass
     * @return
     */
    boolean matches(Method method, Class<?> targetClass);
}
