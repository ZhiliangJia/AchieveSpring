因为我们在使用 Spring、MyBatis 框架的时候都可以知道，并没有手动的去创建任何操作数据库的 Bean 对象，有的仅仅是一个接口定义，而这个接口定义竟然可以被注入到其他需要使用 Dao 的属性中去了，那么这一过程最核心待解决的问题，就是需要完成把复杂且以代理方式动态变化的对象，注册到 Spring 容器中。而为了满足这样的一个扩展组件开发的需求，就需要我们在现有手写的 Spring 框架中，添加这一能力。

![](https://bugstack.cn/assets/images/spring/spring-10-01.png)

- 整个的实现过程包括了两部分，一个解决单例还是原型对象，另外一个处理 FactoryBean 类型对象创建过程中关于获取具体调用对象的 getObject 操作。
- SCOPE_SINGLETON、SCOPE_PROTOTYPE，对象类型的创建获取方式，主要区分在于 AbstractAutowireCapableBeanFactory#createBean 创建完成对象后是否放入到内存中，如果不放入则每次获取都会重新创建。
- createBean 执行对象创建、属性填充、依赖加载、前置后置处理、初始化等操作后，就要开始做执行判断整个对象是否是一个 FactoryBean 对象，如果是这样的对象，就需要再继续执行获取 FactoryBean 具体对象中的 getObject 对象了。整个 getBean 过程中都会新增一个单例类型的判断factory.isSingleton()，用于决定是否使用内存存放对象信息。


参考文献：
1. [小傅哥-【bugstack 虫洞栈】](https://bugstack.cn/)