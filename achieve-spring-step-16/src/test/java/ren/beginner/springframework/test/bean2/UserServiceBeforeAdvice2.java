package ren.beginner.springframework.test.bean2;

import ren.beginner.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @Created by Zhiliang
 * @Date 2023/10/4 22:32
 */
public class UserServiceBeforeAdvice2 implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("拦截方法：" + method.getName());
    }

}
