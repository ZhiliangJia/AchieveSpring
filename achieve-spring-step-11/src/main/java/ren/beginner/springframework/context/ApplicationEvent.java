package ren.beginner.springframework.context;

import java.util.EventObject;

/**
 * 要由所有应用程序事件扩展的类。抽象，因为直接发布一般事件没有意义。
 *
 * @Created by Zhiliang
 * @Date 2023/9/30 14:11
 */
public abstract class ApplicationEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationEvent(Object source) {
        super(source);
    }
}
