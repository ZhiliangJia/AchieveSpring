package ren.beginner.springframework.beans.factory;

import ren.beginner.springframework.beans.BeansException;
import ren.beginner.springframework.context.ApplicationContext;

/**
 * 实现此接口，能感知到所属的 ApplicationContext
 *
 * @Created by Zhiliang
 * @Date 2023/9/22 23:57
 */
public interface ApplicationContextAware extends Aware {
    /**
     * 设置ApplicationContext
     *
     * @param applicationContext
     * @throws BeansException
     */
    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}
