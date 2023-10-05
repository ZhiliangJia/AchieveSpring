按照目前我们实现的 Spring 框架，是可以满足一个基本需求的，但如果你配置了A、B两个Bean对象互相依赖，那么立马会抛出
java.lang.StackOverflowError，为什么呢？因为A创建时需要依赖B创建，而B的创建又依赖于A创建，就这样死循环了。

![](https://bugstack.cn/assets/images/spring/spring-17-04.png)

- 关于循环依赖在我们目前的 Spring 框架中扩展起来也并不会太复杂，主要就是对于创建对象的提前暴露，如果是工厂对象则会使用
  getEarlyBeanReference 逻辑提前将工厂🏭对象存放到三级缓存中。等到后续获取对象的时候实际拿到的是工厂对象中
  getObject，这个才是最终的实际对象。
- 在创建对象的 AbstractAutowireCapableBeanFactory#doCreateBean 方法中，提前暴露对象以后，就可以通过接下来的流程，getSingleton
  从三个缓存中以此寻找对象，一级、二级如果有则直接取走，如果对象是三级缓存中则会从三级缓存中获取后并删掉工厂对象，把实际对象放到二级缓存中。
- 最后是关于单例的对象的注册操作，这个注册操作就是把真实的实际对象放到一级缓存中，因为此时它已经是一个成品对象了。

参考文献：

1. [小傅哥-【bugstack 虫洞栈】](https://bugstack.cn/)