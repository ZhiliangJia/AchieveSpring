package ren.beginner.springframework.aop;

/**
 * 限制切入点匹配或引入到给定目标类集的筛选器。
 *
 * @Created by Zhiliang
 * @Date 2023/9/30 22:02
 */
public interface ClassFilter {
    /**
     * 切入点是否应该应用于给定的接口还是目标类？
     *
     * @param clazz
     * @return
     */
    boolean matches(Class<?> clazz);
}
