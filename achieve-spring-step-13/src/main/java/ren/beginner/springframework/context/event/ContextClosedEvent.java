package ren.beginner.springframework.context.event;

/**
 * 当{@code ApplicationContext}被关闭时引发的事件。
 *
 * @Created by Zhiliang
 * @Date 2023/9/30 14:16
 */
public class ContextClosedEvent extends ApplicationContextEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ContextClosedEvent(Object source) {
        super(source);
    }
}
