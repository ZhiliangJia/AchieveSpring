本章节的案例目标就是定义一个简单的 Spring 容器，用于定义、存放和获取 Bean 对象。

![](https://bugstack.cn/assets/images/spring/spring-2-01.png)

- 定义：BeanDefinition，可能这是你在查阅 Spring 源码时经常看到的一个类，例如它会包括 singleton、prototype、BeanClassName 等。但目前我们初步实现会更加简单的处理，只定义一个 Object 类型用于存放对象。
- 注册：这个过程就相当于我们把数据存放到 HashMap 中，只不过现在 HashMap 存放的是定义了的 Bean 的对象信息。
- 获取：最后就是获取对象，Bean 的名字就是key，Spring 容器初始化好 Bean 以后，就可以直接获取了。

参考文献：
1. [小傅哥-【bugstack 虫洞栈】](https://bugstack.cn/)