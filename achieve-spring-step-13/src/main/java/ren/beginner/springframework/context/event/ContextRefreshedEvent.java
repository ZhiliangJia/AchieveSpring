package ren.beginner.springframework.context.event;

import ren.beginner.springframework.context.ApplicationEvent;

/**
 * 当{@code ApplicationContext}被初始化或刷新时引发的事件。
 *
 * @Created by Zhiliang
 * @Date 2023/9/30 14:15
 */
public class ContextRefreshedEvent extends ApplicationContextEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ContextRefreshedEvent(Object source) {
        super(source);
    }
}
