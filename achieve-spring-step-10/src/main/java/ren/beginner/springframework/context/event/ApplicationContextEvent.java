package ren.beginner.springframework.context.event;

import ren.beginner.springframework.context.ApplicationContext;
import ren.beginner.springframework.context.ApplicationEvent;

/**
 * 为{@Code ApplicationContext}提出的事件的基类。
 *
 * @Created by Zhiliang
 * @Date 2023/9/30 14:13
 */
public class ApplicationContextEvent extends ApplicationEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationContextEvent(Object source) {
        super(source);
    }

    public final ApplicationContext getApplicationContext() {
        return (ApplicationContext) getSource();
    }
}
