package ren.beginner.springframework.context.event;

import ren.beginner.springframework.beans.factory.BeanFactory;
import ren.beginner.springframework.context.ApplicationEvent;
import ren.beginner.springframework.context.ApplicationListener;

/**
 * 接口{@link ApplicationEventMulticaster}的简单实现。
 *
 * @Created by Zhiliang
 * @Date 2023/9/30 15:31
 */
public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster {

    public SimpleApplicationEventMulticaster(BeanFactory beanFactory) {
        setBeanFactory(beanFactory);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void multicastEvent(ApplicationEvent event) {
        for (final ApplicationListener listener : getApplicationListeners(event)) {
            listener.onApplicationEvent(event);
        }
    }
}
