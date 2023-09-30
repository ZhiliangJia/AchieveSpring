package ren.beginner.springframework.test.event;

import ren.beginner.springframework.context.ApplicationListener;
import ren.beginner.springframework.context.event.ContextClosedEvent;

/**
 * @Created by Zhiliang
 * @Date 2023/9/30 16:53
 */
public class ContextClosedEventListener implements ApplicationListener<ContextClosedEvent> {
    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println("关闭事件：" + this.getClass().getName());
    }
}
