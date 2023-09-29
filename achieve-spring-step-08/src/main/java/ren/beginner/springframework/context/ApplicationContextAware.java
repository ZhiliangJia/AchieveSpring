package ren.beginner.springframework.context;


import ren.beginner.springframework.beans.BeansException;
import ren.beginner.springframework.beans.factory.Aware;

/**
 * 接口可以被任何对象实现，只要对象希望得到它所运行的{@link ApplicationContext}的通知。
 *
 * @Created by Zhiliang
 * @Date 2023/9/23 0:04
 */
public interface ApplicationContextAware extends Aware {
    /**
     * 通常，这个调用将用于初始化对象。
     *
     * @param applicationContext
     * @throws BeansException
     */
    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}
