我们需要在本章节完成 AOP 核心功能与 Spring 框架的整合，最终能通过在 Spring 配置的方式完成切面的操作。
![](https://bugstack.cn/assets/images/spring/spring-13-01.png)

- 为了可以让对象创建过程中，能把xml中配置的代理对象也就是切面的一些类对象实例化，就需要用到 BeanPostProcessor 提供的方法，因为这个类的中的方法可以分别作用与 Bean 对象执行初始化前后修改 Bean 的对象的扩展信息。但这里需要集合于 BeanPostProcessor 实现新的接口和实现类，这样才能定向获取对应的类信息。
- 但因为创建的是代理对象不是之前流程里的普通对象，所以我们需要前置于其他对象的创建，所以在实际开发的过程中，需要在 AbstractAutowireCapableBeanFactory#createBean 优先完成 Bean 对象的判断，是否需要代理，有则直接返回代理对象。在Spring的源码中会有 createBean 和 doCreateBean 的方法拆分
- 这里还包括要解决方法拦截器的具体功能，提供一些 BeforeAdvice、AfterAdvice 的实现，让用户可以更简化的使用切面功能。除此之外还包括需要包装切面表达式以及拦截方法的整合，以及提供不同类型的代理方式的代理工厂，来包装我们的切面服务。

参考文献：

1. [小傅哥-【bugstack 虫洞栈】](https://bugstack.cn/)