在完成 Spring 的框架雏形后，现在我们可以通过单元测试进行手动操作 Bean 对象的定义、注册和属性填充，以及最终获取对象调用方法。但这里会有一个问题，就是如果实际使用这个 Spring 框架，是不太可能让用户通过手动方式创建的，而是最好能通过配置文件的方式简化创建过程。

![](https://bugstack.cn/assets/images/spring/spring-6-02.png)

- 资源加载器属于相对独立的部分，它位于 Spring 框架核心包下的IO实现内容，主要用于处理Class、本地和云环境中的文件信息。
- 当资源可以加载后，接下来就是解析和注册 Bean 到 Spring 中的操作，这部分实现需要和 DefaultListableBeanFactory 核心类结合起来，因为你所有的解析后的注册动作，都会把 Bean 定义信息放入到这个类中。
- 那么在实现的时候就设计好接口的实现层级关系，包括我们需要定义出 Bean 定义的读取接口 BeanDefinitionReader 以及做好对应的实现类，在实现类中完成对 Bean 对象的解析和注册。

参考文献：
1. [小傅哥-【bugstack 虫洞栈】](https://bugstack.cn/)