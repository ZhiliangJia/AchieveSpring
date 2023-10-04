package ren.beginner.springframework.aop;

import org.aopalliance.aop.Advice;

/**
 * 持有AOP＜b＞建议</b＞（在连接点采取的操作）和确定建议适用性的过滤器（如切入点）的基本接口<i> 这个接口
 * 不供Spring用户使用，但允许对不同类型的建议提供通用性支持</i>
 *
 * @Created by Zhiliang
 * @Date 2023/10/1 21:40
 */
public interface Advisor {
    /**
     * 返回此方面的Advice部分。建议可以是拦截器、事前建议、抛出建议等。
     *
     * @return
     */
    Advice getAdvice();
}
