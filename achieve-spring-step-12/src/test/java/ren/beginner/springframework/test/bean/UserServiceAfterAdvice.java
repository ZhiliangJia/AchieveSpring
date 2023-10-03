package ren.beginner.springframework.test.bean;

import ren.beginner.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * @Created by Zhiliang
 * @Date 2023/10/3 20:30
 */
public class UserServiceAfterAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("After 拦截方法：" + method.getName());
    }
}
