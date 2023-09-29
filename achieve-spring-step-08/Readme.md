如果我们想获得 Spring 框架提供的 BeanFactory、ApplicationContext、BeanClassLoader等这些能力做一些扩展框架的使用时该怎么操作呢。所以我们本章节希望在 Spring 框架中提供一种能感知容器操作的接口，如果谁实现了这样的一个接口，就可以获取接口入参中的各类能力。

![](https://bugstack.cn/assets/images/spring/spring-9-01.png)

- 定义接口 Aware，在 Spring 框架中它是一种感知标记性接口，具体的子类定义和实现能感知容器中的相关对象。也就是通过这个桥梁，向具体的实现类中提供容器服务
- 继承 Aware 的接口包括：BeanFactoryAware、BeanClassLoaderAware、BeanNameAware和ApplicationContextAware，当然在 Spring 源码中还有一些其他关于注解的，不过目前我们还是用不到。
- 在具体的接口实现过程中你可以看到，一部分(BeanFactoryAware、BeanClassLoaderAware、BeanNameAware)在 factory 的 support 文件夹下，另外 ApplicationContextAware 是在 context 的 support 中，这是因为不同的内容获取需要在不同的包下提供。所以，在 AbstractApplicationContext 的具体实现中会用到向 beanFactory 添加 BeanPostProcessor 内容的 ApplicationContextAwareProcessor 操作，最后由 AbstractAutowireCapableBeanFactory 创建 createBean 时处理相应的调用操作。关于 applyBeanPostProcessorsBeforeInitialization 已经在前面章节中实现过，如果忘记可以往前翻翻


参考文献：
1. [小傅哥-【bugstack 虫洞栈】](https://bugstack.cn/)