那么在自动扫描包注册 Bean 对象之后，就需要把原来在配置文件中通过 property name="token" 配置属性和Bean的操作，也改为可以自动注入。这就像我们使用 Spring 框架中 @Autowired、@Value 注解一样，完成我们对属性和对象的注入操作。

![](https://bugstack.cn/assets/images/spring/spring-15-01.png)

- 要处理自动扫描注入，包括属性注入、对象注入，则需要在对象属性 applyPropertyValues 填充之前 ，把属性信息写入到 PropertyValues 的集合中去。这一步的操作相当于是解决了以前在 spring.xml 配置属性的过程。
- 而在属性的读取中，需要依赖于对 Bean 对象的类中属性的配置了注解的扫描，field.getAnnotation(Value.class); 依次拿出符合的属性并填充上相应的配置信息。这里有一点 ，属性的配置信息需要依赖于 BeanFactoryPostProcessor 的实现类 PropertyPlaceholderConfigurer，把值写入到 AbstractBeanFactory的embeddedValueResolvers集合中，这样才能在属性填充中利用 beanFactory 获取相应的属性值
- 还有一个是关于 @Autowired 对于对象的注入，其实这一个和属性注入的唯一区别是对于对象的获取 beanFactory.getBean(fieldType)，其他就没有什么差一点了。
- 当所有的属性被设置到 PropertyValues 完成以后，接下来就到了创建对象的下一步，属性填充，而此时就会把我们一一获取到的配置和对象填充到属性上，也就实现了自动注入的功能。

参考文献：

1. [小傅哥-【bugstack 虫洞栈】](https://bugstack.cn/)