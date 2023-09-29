需要满足用户可以在 xml 中配置初始化和销毁的方法，也可以通过实现类的方式处理，比如我们在使用 Spring 时用到的 InitializingBean, DisposableBean 两个接口。其实还可以有一种是注解的方式处理初始化操作，不过目前还没有实现到注解的逻辑，后续再完善此类功能。

![](https://bugstack.cn/assets/images/spring/spring-8-03.png)

- 在 spring.xml 配置中添加 init-method、destroy-method 两个注解，在配置文件加载的过程中，把注解配置一并定义到 BeanDefinition 的属性当中。这样在 initializeBean 初始化操作的工程中，就可以通过反射的方式来调用配置在 Bean 定义属性当中的方法信息了。另外如果是接口实现的方式，那么直接可以通过 Bean 对象调用对应接口定义的方法即可，((InitializingBean) bean).afterPropertiesSet()，两种方式达到的效果是一样的。
- 除了在初始化做的操作外，destroy-method 和 DisposableBean 接口的定义，都会在 Bean 对象初始化完成阶段，执行注册销毁方法的信息到 DefaultSingletonBeanRegistry 类中的 disposableBeans 属性里，这是为了后续统一进行操作。这里还有一段适配器的使用，因为反射调用和接口直接调用，是两种方式。所以需要使用适配器进行包装，下文代码讲解中参考 DisposableBeanAdapter 的具体实现 -关于销毁方法需要在虚拟机执行关闭之前进行操作，所以这里需要用到一个注册钩子的操作，如：Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("close！"))); 这段代码你可以执行测试，另外你可以使用手动调用 ApplicationContext.close 方法关闭容器。


参考文献：
1. [小傅哥-【bugstack 虫洞栈】](https://bugstack.cn/)