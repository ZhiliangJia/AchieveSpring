package ren.beginner.springframework.context.annotation;

import java.lang.annotation.*;

/**
 * 用于配置作用域的自定义注解，方便通过配置Bean对象注解的时候，拿到Bean对象的作用域。
 *
 * @Created by Zhiliang
 * @Date 2023/10/3 21:46
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Scope {

    String value() default "singleton";
}
