我们的目标就是在目前的核心逻辑上填充一些自动化的功能，让大家可以学习到这部分的设计和实现，从中体会到一些关于代码逻辑的实现过程，总结一些编码经验。
![](https://bugstack.cn/assets/images/spring/spring-14-01.png)

- 自动扫描注册主要是扫描添加了自定义注解的类，在xml加载过程中提取类的信息，组装 BeanDefinition 注册到 Spring 容器中。
- 所以我们会用到 <context:component-scan /> 配置包路径并在 XmlBeanDefinitionReader 解析并做相应的处理。这里的处理会包括对类的扫描、获取注解信息等
- 最后还包括了一部分关于 BeanFactoryPostProcessor 的使用，因为我们需要完成对占位符配置信息的加载，所以需要使用到 BeanFactoryPostProcessor 在所有的 BeanDefinition 加载完成后，实例化 Bean 对象之前，修改 BeanDefinition 的属性信息。这一部分的实现也为后续处理关于占位符配置到注解上做准备

参考文献：

1. [小傅哥-【bugstack 虫洞栈】](https://bugstack.cn/)