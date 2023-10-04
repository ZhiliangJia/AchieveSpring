package ren.beginner.springframework.aop;

import ren.beginner.springframework.util.ClassUtils;

/**
 * {@code TargetSource}用于获取AOP调用的当前“目标”，如果没有around通知选择结束拦截器链本身，则将通过反射调用该目标。
 *
 * @Created by Zhiliang
 * @Date 2023/9/30 22:51
 */
public class TargetSource {
    /**
     * 代理类
     */
    private final Object target;

    public TargetSource(Object target) {
        this.target = target;
    }

    /**
     * 返回此{@link TargetSource}返回的目标类型。
     *
     * @return
     */
    public Class<?>[] getTargetClass() {
        Class<?> clazz = this.target.getClass();
        clazz = ClassUtils.isCglibProxyClass(clazz) ? clazz.getSuperclass() : clazz;
        return clazz.getInterfaces();
    }

    public Object getTarget() {
        return target;
    }
}
