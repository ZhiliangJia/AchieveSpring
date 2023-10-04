package ren.beginner.springframework.aop;

/**
 * 由切入点驱动的所有Advisor的超级接口。这几乎涵盖了除介绍顾问之外的所有顾问，方法级别匹配不适用于介绍顾问。
 *
 * @Created by Zhiliang
 * @Date 2023/10/1 21:39
 */
public interface PointcutAdvisor extends Advisor {
    /**
     * 获取Advisor此顾问的切入点。
     *
     * @return
     */
    Pointcut getPointcut();
}
