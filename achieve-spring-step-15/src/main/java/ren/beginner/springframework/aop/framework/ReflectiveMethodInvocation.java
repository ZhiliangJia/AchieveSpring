package ren.beginner.springframework.aop.framework;

import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;

/**
 * Spring对AOP-Alliance MethodInvocation 接口的实现，实现扩展的 ProxyMethodInvocation 接口。
 *
 * @Created by Zhiliang
 * @Date 2023/9/30 23:02
 */
public class ReflectiveMethodInvocation implements MethodInvocation {
    /**
     * 目标对象
     */
    protected final Object target;
    /**
     * 方法
     */
    protected final Method method;
    /**
     * 入参
     */
    protected final Object[] arguments;

    public ReflectiveMethodInvocation(Object target, Method method, Object[] arguments) {
        this.target = target;
        this.method = method;
        this.arguments = arguments;
    }

    @Override
    public Method getMethod() {
        return method;
    }

    @Override
    public Object[] getArguments() {
        return arguments;
    }

    @Override
    public Object proceed() throws Throwable {
        return method.invoke(target, arguments);
    }

    @Override
    public Object getThis() {
        return target;
    }

    @Override
    public AccessibleObject getStaticPart() {
        return method;
    }
}
