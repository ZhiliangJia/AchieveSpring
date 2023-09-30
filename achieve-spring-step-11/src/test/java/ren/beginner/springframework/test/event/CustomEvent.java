package ren.beginner.springframework.test.event;

import ren.beginner.springframework.context.event.ApplicationContextEvent;

/**
 * @Created by Zhiliang
 * @Date 2023/9/30 16:48
 */
public class CustomEvent extends ApplicationContextEvent {
    private Long id;
    private String message;

    public CustomEvent(Object source, Long id, String message) {
        super(source);
        this.id = id;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
