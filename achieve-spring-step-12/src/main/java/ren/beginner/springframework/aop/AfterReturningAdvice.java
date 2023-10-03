package ren.beginner.springframework.aop;

import java.lang.reflect.Method;

/**
 * 返回通知仅在正常方法返回时调用，而不是在抛出异常时调用。这样的通知可以看到返回值，但不能更改它。
 *
 * @Created by Zhiliang
 * @Date 2023/10/3 20:17
 */
public interface AfterReturningAdvice extends AfterAdvice {

    /**
     * @param returnValue
     * @param method
     * @param args
     * @param target
     */
    void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable;
}
