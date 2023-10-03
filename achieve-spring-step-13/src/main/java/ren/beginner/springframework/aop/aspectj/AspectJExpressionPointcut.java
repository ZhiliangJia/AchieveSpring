package ren.beginner.springframework.aop.aspectj;

import org.aspectj.weaver.tools.PointcutExpression;
import org.aspectj.weaver.tools.PointcutParser;
import ren.beginner.springframework.aop.ClassFilter;
import ren.beginner.springframework.aop.MethodMatcher;
import ren.beginner.springframework.aop.Pointcut;

import org.aspectj.weaver.tools.PointcutPrimitive;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

/**
 * Spring{@link-org.springframework.aop.Pointcut}实现，使用AspectJ编织器计算切入点表达式。
 *
 * @Created by Zhiliang
 * @Date 2023/9/30 22:31
 */
public class AspectJExpressionPointcut implements Pointcut, ClassFilter, MethodMatcher {
    /**
     * PointcutPrimitive的集合
     */
    private static final Set<PointcutPrimitive> SUPPORTED_PRIMITIVES = new HashSet<>();

    static {
        SUPPORTED_PRIMITIVES.add(PointcutPrimitive.EXECUTION);
    }

    /**
     * Pointcut的表达式
     */
    private final PointcutExpression pointcutExpression;

    public AspectJExpressionPointcut(String expression) {
        PointcutParser pointcutParser = PointcutParser.getPointcutParserSupportingSpecifiedPrimitivesAndUsingSpecifiedClassLoaderForResolution(SUPPORTED_PRIMITIVES, this.getClass().getClassLoader());
        pointcutExpression = pointcutParser.parsePointcutExpression(expression);
    }

    @Override
    public boolean matches(Class<?> clazz) {
        return pointcutExpression.couldMatchJoinPointsInType(clazz);
    }

    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        return pointcutExpression.matchesMethodExecution(method).alwaysMatches();
    }

    @Override
    public ClassFilter getClassFilter() {
        return this;
    }

    @Override
    public MethodMatcher getMethodMatcher() {
        return this;
    }
}
