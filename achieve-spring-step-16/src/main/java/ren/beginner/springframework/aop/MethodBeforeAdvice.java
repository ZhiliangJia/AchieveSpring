package ren.beginner.springframework.aop;

import java.lang.reflect.Method;

/**
 * 在调用方法之前调用的通知。这样的通知不能阻止方法调用的继续，除非它们抛出Throwable。
 *
 * @Created by Zhiliang
 * @Date 2023/10/1 21:51
 */
public interface MethodBeforeAdvice extends BeforeAdvice {
    /**
     * 调用给定方法之前的回调。
     *
     * @param method
     * @param args
     * @param target
     * @throws Throwable
     */
    void before(Method method, Object[] args, Object target) throws Throwable;
}
