代理类的实现基本都大家都见过，那么有了一个基本的思路后，接下来就需要考虑下怎么给方法做代理呢，而不是代理类。另外怎么去代理所有符合某些规则的所有类中方法呢。如果可以代理掉所有类的方法，就可以做一个方法拦截器，给所有被代理的方法添加上一些自定义处理，比如打印日志、记录耗时、监控异常等。

![](https://bugstack.cn/assets/images/spring/spring-12-01.png)

- 就像你在使用 Spring 的 AOP 一样，只处理一些需要被拦截的方法。在拦截方法后，执行你对方法的扩展操作。
- 那么我们就需要先来实现一个可以代理方法的 Proxy，其实代理方法主要是使用到方法拦截器类处理方法的调用
  MethodInterceptor#invoke，而不是直接使用 invoke 方法中的入参 Method method 进行 method.invoke(targetObj, args)
  这块是整个使用时的差异。
- 除了以上的核心功能实现，还需要使用到 org.aspectj.weaver.tools.PointcutParser 处理拦截表达式 "execution(*
  cn.bugstack.springframework.test.bean.IUserService.*(..))"，有了方法代理和处理拦截，我们就可以完成设计出一个 AOP 的雏形了。

参考文献：

1. [小傅哥-【bugstack 虫洞栈】](https://bugstack.cn/)