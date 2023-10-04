package ren.beginner.springframework.beans.factory.annotation;

import java.lang.annotation.*;

/**
 * 在字段或方法/构造函数参数级别上指示受影响参数的默认值表达式的注释。
 *
 * @Created by Zhiliang
 * @Date 2023/10/4 15:54
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Value {
    /**
     * 表达式
     *
     * @return
     */
    String value() default "";
}
