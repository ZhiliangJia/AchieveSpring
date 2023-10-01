package ren.beginner.springframework.aop.framework;

/**
 * 已配置AOP代理的委托接口，允许创建实际的代理对象。
 *
 * @Created by Zhiliang
 * @Date 2023/9/30 22:59
 */
public interface AopProxy {
    /**
     * 创建新的代理对象<p> 使用AopProxy的默认类装入器（如果创建代理需要）：通常是线程上下文类装入器。
     *
     * @return
     */
    Object getProxy();
}
