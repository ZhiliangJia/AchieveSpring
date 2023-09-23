缺少一个关于类中是否有属性的问题，如果有类中包含属性那么在实例化的时候就需要把属性信息填充上，这样才是一个完整的对象创建。

对于属性的填充不只是 int、Long、String，还包括还没有实例化的对象属性，都需要在 Bean 创建时进行填充操作。不过这里我们暂时不会考虑 Bean 的循环依赖，否则会把整个功能实现撑大，这样新人学习时就把握不住了，待后续陆续先把核心功能实现后，再逐步完善



![](https://bugstack.cn/assets/images/spring/spring-5-01.png)

- 属性填充要在类实例化创建之后，也就是需要在 AbstractAutowireCapableBeanFactory 的 createBean 方法中添加 applyPropertyValues 操作。
- 由于我们需要在创建Bean时候填充属性操作，那么就需要在 bean 定义 BeanDefinition 类中，添加 PropertyValues 信息。
- 另外是填充属性信息还包括了 Bean 的对象类型，也就是需要再定义一个 BeanReference，里面其实就是一个简单的 Bean 名称，在具体的实例化操作时进行递归创建和填充，与 Spring 源码实现一样。Spring 源码中 BeanReference 是一个接口。

参考文献：
1. [小傅哥-【bugstack 虫洞栈】](https://bugstack.cn/)