package ren.beginner.springframework.test.event;

import ren.beginner.springframework.context.ApplicationListener;
import ren.beginner.springframework.context.event.ContextRefreshedEvent;

/**
 * @Created by Zhiliang
 * @Date 2023/9/30 16:54
 */
public class ContextRefreshedEventListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("刷新事件：" + this.getClass().getName());
    }
}
