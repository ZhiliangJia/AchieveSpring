package ren.beginner.springframework.context;

import java.util.EventListener;

/**
 * 要由应用程序事件侦听器实现的接口。
 *
 * @Created by Zhiliang
 * @Date 2023/9/30 14:18
 */
public interface ApplicationListener<E extends ApplicationEvent> extends EventListener {
    /**
     * 处理应用程序事件。
     *
     * @param event
     */
    void onApplicationEvent(E event);
}
