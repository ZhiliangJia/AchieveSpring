package ren.beginner.springframework.test;

import org.aopalliance.intercept.MethodInterceptor;
import org.junit.Test;
import ren.beginner.springframework.aop.AdvisedSupport;
import ren.beginner.springframework.aop.MethodMatcher;
import ren.beginner.springframework.aop.TargetSource;
import ren.beginner.springframework.aop.aspectj.AspectJExpressionPointcut;
import ren.beginner.springframework.aop.framework.Cglib2AopProxy;
import ren.beginner.springframework.aop.framework.JdkDynamicAopProxy;
import ren.beginner.springframework.aop.framework.ReflectiveMethodInvocation;
import ren.beginner.springframework.test.bean.IUserService;
import ren.beginner.springframework.test.bean.UserService;
import ren.beginner.springframework.test.bean.UserServiceInterceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ApiTest {

    @Test
    public void testAop() throws NoSuchMethodException {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut("execution(* ren.beginner.springframework.test.bean.UserService.*(..))");

        Class<UserService> clazz = UserService.class;
        Method method = clazz.getDeclaredMethod("queryUserInfo");

        System.out.println(pointcut.matches(clazz));
        System.out.println(pointcut.matches(method, clazz));
    }

    @Test
    public void testDynamic() {
        IUserService userService = new UserService();

        AdvisedSupport advisedSupport = new AdvisedSupport();
        advisedSupport.setTargetSource(new TargetSource(userService));
        advisedSupport.setMethodInterceptor(new UserServiceInterceptor());
        advisedSupport.setMethodMatcher(new AspectJExpressionPointcut("execution(* ren.beginner.springframework.test.bean.IUserService.*(..))"));

        IUserService proxyJdk = (IUserService) new JdkDynamicAopProxy(advisedSupport).getProxy();
        System.out.println("测试结果：" + proxyJdk.queryUserInfo());

        IUserService proxyCglib = (IUserService) new Cglib2AopProxy(advisedSupport).getProxy();
        System.out.println("测试结果：" + proxyCglib.register("Jzl"));
    }

    @Test
    public void testProxyClass() {
        IUserService userService = (IUserService) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{IUserService.class}, (proxy, method, args) -> "你被代理了！");
        System.out.println("测试结果：" + userService.queryUserInfo());
        System.out.println("测试结果：" + userService.register("Jzl"));
    }

    @Test
    public void testProxyMethod() {
        UserService targetObj = new UserService();

        IUserService proxy = (IUserService) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), targetObj.getClass().getInterfaces(), new InvocationHandler() {
            MethodMatcher methodMatcher = new AspectJExpressionPointcut("execution(* ren.beginner.springframework.test.bean.IUserService.register(..))");

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (methodMatcher.matches(method, targetObj.getClass())) {
                    MethodInterceptor methodInterceptor = invocation -> {
                        long start = System.currentTimeMillis();
                        try {
                            return invocation.proceed();
                        } finally {
                            System.out.println("\n监控 - Begin By AOP");
                            System.out.println("方法名称：" + invocation.getMethod().getName());
                            System.out.println("方法耗时：" + (System.currentTimeMillis() - start) + "ms");
                            System.out.println("监控 - End");
                        }
                    };
                    return methodInterceptor.invoke(new ReflectiveMethodInvocation(targetObj, method, args));
                }
                return method.invoke(targetObj, args);
            }
        });

        System.out.println("测试结果：" + proxy.queryUserInfo());
        System.out.println("测试结果：" + proxy.register("Jzl"));
    }
}
