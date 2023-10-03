package ren.beginner.springframework.test.bean;

import ren.beginner.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @Created by Zhiliang
 * @Date 2023/10/2 19:56
 */
public class UserServiceBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("Before 拦截方法：" + method.getName());
    }
}
