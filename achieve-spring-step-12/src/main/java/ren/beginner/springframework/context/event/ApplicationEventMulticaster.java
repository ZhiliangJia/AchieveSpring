package ren.beginner.springframework.context.event;

import ren.beginner.springframework.context.ApplicationEvent;
import ren.beginner.springframework.context.ApplicationListener;

/**
 * 接口将被对象实现，这些对象可以管理许多{@link ApplicationListener}对象并向它们发布事件。
 *
 * @Created by Zhiliang
 * @Date 2023/9/30 14:17
 */
public interface ApplicationEventMulticaster {
    /**
     * 添加一个新的应用程序列表，将在上下文事件中通知，例如上下文刷新和上下文关闭。
     *
     * @param listener
     */
    void addApplicationListener(ApplicationListener<?> listener);

    /**
     * 从此上下文的侦听器集中删除给定的ApplicationListener，假设它之前通过{@link #addApplicationListener}注册。
     *
     * @param listener
     */
    void removeApplicationListener(ApplicationListener<?> listener);

    /**
     * 将给定的应用程序事件多播到适当的侦听器。
     *
     * @param event
     */
    void multicastEvent(ApplicationEvent event);
}
