package ren.beginner.springframework.test;

import org.aopalliance.intercept.MethodInterceptor;
import org.junit.Before;
import org.junit.Test;
import ren.beginner.springframework.aop.AdvisedSupport;
import ren.beginner.springframework.aop.ClassFilter;
import ren.beginner.springframework.aop.MethodMatcher;
import ren.beginner.springframework.aop.TargetSource;
import ren.beginner.springframework.aop.aspectj.AspectJExpressionPointcut;
import ren.beginner.springframework.aop.aspectj.AspectJExpressionPointcutAdvisor;
import ren.beginner.springframework.aop.framework.Cglib2AopProxy;
import ren.beginner.springframework.aop.framework.JdkDynamicAopProxy;
import ren.beginner.springframework.aop.framework.ProxyFactory;
import ren.beginner.springframework.aop.framework.ReflectiveMethodInvocation;
import ren.beginner.springframework.aop.framework.adapter.AfterReturningAdviceInterceptor;
import ren.beginner.springframework.aop.framework.adapter.MethodBeforeAdviceInterceptor;
import ren.beginner.springframework.context.support.ClassPathXmlApplicationContext;
import ren.beginner.springframework.test.bean.*;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ApiTest {
    private AdvisedSupport advisedSupport;

    @Before
    public void init() {
        IUserService userService = new UserService();
        advisedSupport = new AdvisedSupport();
        advisedSupport.setTargetSource(new TargetSource(userService));
        advisedSupport.setMethodInterceptor(new UserServiceInterceptor());
        advisedSupport.setMethodMatcher(new AspectJExpressionPointcut("execution(* ren.beginner.springframework.test.bean.IUserService.*(..))"));
    }

    @Test
    public void testProxyFactory() {
        advisedSupport.setProxyTargetClass(true);

        IUserService proxy = (IUserService) new ProxyFactory(advisedSupport).getProxy();
        System.out.println("测试结果：" + proxy.queryUserInfo());
    }

    @Test
    public void testBeforeAdvice() {
        UserServiceBeforeAdvice beforeAdvice = new UserServiceBeforeAdvice();
        MethodBeforeAdviceInterceptor interceptor = new MethodBeforeAdviceInterceptor(beforeAdvice);
        advisedSupport.setMethodInterceptor(interceptor);

        IUserService proxy = (IUserService) new ProxyFactory(advisedSupport).getProxy();
        System.out.println("测试结果：" + proxy.queryUserInfo());
    }

    @Test
    public void testAdvisor() {
        IUserService userService = new UserService();

        AspectJExpressionPointcutAdvisor advisor = new AspectJExpressionPointcutAdvisor();
        advisor.setExpression("execution(* ren.beginner.springframework.test.bean.IUserService.*(..))");
        advisor.setAdvice(new MethodBeforeAdviceInterceptor(new UserServiceBeforeAdvice()));

        ClassFilter classFilter = advisor.getPointcut().getClassFilter();
        if (classFilter.matches(userService.getClass())) {
            AdvisedSupport support = new AdvisedSupport();

            TargetSource targetSource = new TargetSource(userService);
            support.setTargetSource(targetSource);
            support.setMethodInterceptor((MethodInterceptor) advisor.getAdvice());
            support.setMethodMatcher(advisedSupport.getMethodMatcher());
            support.setProxyTargetClass(false); // false-JDK动态代理 true-CGlib动态代理

            IUserService proxy = (IUserService) new ProxyFactory(support).getProxy();
            System.out.println("测试结果：" + proxy.queryUserInfo());
        }
    }

    @Test
    public void testAfterAdvisor() {
        IUserService userService = new UserService();

        AspectJExpressionPointcutAdvisor advisor = new AspectJExpressionPointcutAdvisor();
        advisor.setExpression("execution(* ren.beginner.springframework.test.bean.IUserService.*(..))");
        advisor.setAdvice(new AfterReturningAdviceInterceptor(new UserServiceAfterAdvice()));

        ClassFilter classFilter = advisor.getPointcut().getClassFilter();
        if (classFilter.matches(userService.getClass())) {
            AdvisedSupport support = new AdvisedSupport();

            TargetSource targetSource = new TargetSource(userService);
            support.setTargetSource(targetSource);
            support.setMethodInterceptor((MethodInterceptor) advisor.getAdvice());
            support.setMethodMatcher(advisedSupport.getMethodMatcher());
            support.setProxyTargetClass(false); // false-JDK动态代理 true-CGlib动态代理

            IUserService proxy = (IUserService) new ProxyFactory(support).getProxy();
            System.out.println("测试结果：" + proxy.register("Jzl"));
        }
    }

    @Test
    public void testAop() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");

        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        System.out.println("测试结果：" + userService.queryUserInfo());
    }

    @Test
    public void testAopAfter() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");

        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        System.out.println("测试结果：" + userService.register("Jzl"));
    }

    @Test
    public void testProxyMethod() {
        Object targetObj = new UserService();

        IUserService proxy = (IUserService) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), targetObj.getClass().getInterfaces(), new InvocationHandler() {
            MethodMatcher methodMatcher = new AspectJExpressionPointcut("execution(* ren.beginner.springframework.test.bean.IUserService.*(..))");

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (methodMatcher.matches(method, targetObj.getClass())) {
                    MethodInterceptor interceptor = invocation -> {
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
                    return interceptor.invoke(new ReflectiveMethodInvocation(targetObj, method, args));
                }
                return method.invoke(targetObj, args);
            }
        });

        System.out.println("测试结果：" + proxy.queryUserInfo());
    }
}
