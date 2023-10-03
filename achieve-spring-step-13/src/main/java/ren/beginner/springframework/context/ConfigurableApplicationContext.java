package ren.beginner.springframework.context;

import ren.beginner.springframework.beans.BeansException;

/**
 * SPI接口将由大多数（如果不是所有的话）应用程序上下文实现。除了
 * ｛@link-cn.bugstack.springframework.context.ApplicationContext｝接口中的应用程序上下文客
 * 户端方法之外，还提供配置应用程序上下文的工具。
 *
 * @Created by Zhiliang
 * @Date 2023/9/22 11:15
 */
public interface ConfigurableApplicationContext extends ApplicationContext {

    /**
     * 刷新容器
     *
     * @throws BeansException
     */
    void refresh() throws BeansException;

    /**
     * 注册关闭钩子
     */
    void registerShutdownHook();

    /**
     * 关闭方法
     */
    void close();
}
