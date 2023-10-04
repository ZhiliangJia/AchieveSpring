package ren.beginner.springframework.context;

/**
 * 封装事件发布功能的接口
 *
 * @Created by Zhiliang
 * @Date 2023/9/30 15:20
 */
public interface ApplicationEventPublisher {

    /**
     * 将应用程序事件通知在此应用程序中注册的所有侦听器。事件可以是框架事件(如RequestHandledEvent)或特定于应用程序的事件。
     *
     * @param event
     */
    void publishEvent(ApplicationEvent event);
}
