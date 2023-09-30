package ren.beginner.springframework.test.event;

import ren.beginner.springframework.context.ApplicationListener;

import java.util.Date;

/**
 * @Created by Zhiliang
 * @Date 2023/9/30 16:50
 */
public class CustomEventListener implements ApplicationListener<CustomEvent> {
    @Override
    public void onApplicationEvent(CustomEvent event) {
        System.out.println("收到：" + event.getSource() + "消息;时间：" + new Date());
        System.out.println("消息：" + event.getId() + ":" + event.getMessage());
    }
}
