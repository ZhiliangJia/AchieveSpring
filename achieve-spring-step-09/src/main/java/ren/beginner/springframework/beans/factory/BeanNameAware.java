package ren.beginner.springframework.beans.factory;

/**
 * 实现此接口，能感知到所属的 BeanName
 *
 * @Created by Zhiliang
 * @Date 2023/9/22 23:56
 */
public interface BeanNameAware extends Aware {
    /**
     * 设置bBeanName
     *
     * @param beanName
     */
    void setBeanName(String beanName);
}
