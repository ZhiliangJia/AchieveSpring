package ren.beginner.springframework.aop.framework.adapter;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import ren.beginner.springframework.aop.MethodBeforeAdvice;

/**
 * MethodBeforeAdviceInterceptor 实现了 MethodInterceptor 接口，在 invoke 方法中调用 advice 中的 before 方法，传入对应的参数信息。
 *
 * @Created by Zhiliang
 * @Date 2023/10/1 22:51
 */
public class MethodBeforeAdviceInterceptor implements MethodInterceptor {
    /**
     * 通知方法
     */
    private MethodBeforeAdvice advice;

    public MethodBeforeAdviceInterceptor() {
    }

    public MethodBeforeAdviceInterceptor(MethodBeforeAdvice advice) {
        this.advice = advice;
    }

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        this.advice.before(methodInvocation.getMethod(), methodInvocation.getArguments(), methodInvocation.getThis());
        return methodInvocation.proceed();
    }
}
