package ren.beginner.springframework.aop.framework.adapter;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import ren.beginner.springframework.aop.AfterReturningAdvice;

/**
 * 拦截器包装{@link ren.beginner.springframework.aop.AfterReturningAdvice}。由AOP框架内部使用;应用程序开发人员不需要直接使用这个类。
 *
 * @Created by Zhiliang
 * @Date 2023/10/3 20:21
 */
public class AfterReturningAdviceInterceptor implements MethodInterceptor {
    /**
     * 通知方法
     */
    private AfterReturningAdvice advice;

    public AfterReturningAdviceInterceptor() {
    }

    public AfterReturningAdviceInterceptor(AfterReturningAdvice advice) {
        this.advice = advice;
    }

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Object returnValue = methodInvocation.proceed();
        this.advice.afterReturning(returnValue, methodInvocation.getMethod(), methodInvocation.getArguments(), methodInvocation.getThis());
        return returnValue;
    }
}
