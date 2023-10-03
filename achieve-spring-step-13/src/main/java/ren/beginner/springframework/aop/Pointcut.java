package ren.beginner.springframework.aop;

/**
 * 切入点由{@link ClassFilter}和{@link MethodMatcher}组成。
 *
 * @Created by Zhiliang
 * @Date 2023/9/30 22:01
 */
public interface Pointcut {
    /**
     * 返回此切入点的ClassFilter
     *
     * @return
     */
    ClassFilter getClassFilter();

    /**
     * 返回此切入点的MethodMatcher
     *
     * @return
     */
    MethodMatcher getMethodMatcher();
}
