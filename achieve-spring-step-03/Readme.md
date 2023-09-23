处理实例方式未考虑构造函数的情况，

![](https://bugstack.cn/assets/images/spring/spring-4-01.png)

- 参考 Spring Bean 容器源码的实现方式，在 BeanFactory 中添加 Object getBean(String name, Object... args) 接口，这样就可以在获取 Bean 时把构造函数的入参信息传递进去了。
- 另外一个核心的内容是使用什么方式来创建含有构造函数的 Bean 对象呢？这里有两种方式可以选择，一个是基于 **Java** 本身自带的方法 DeclaredConstructor，另外一个是使用 **Cglib** 来动态创建 Bean 对象。Cglib 是基于字节码框架 ASM 实现，所以你也可以直接通过 ASM 操作指令码来创建对象

参考文献：
1. [小傅哥-【bugstack 虫洞栈】](https://bugstack.cn/)