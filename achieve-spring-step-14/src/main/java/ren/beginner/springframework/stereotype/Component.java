package ren.beginner.springframework.stereotype;

import java.lang.annotation.*;

/**
 * 用于配置到 Class 类上
 *
 * @Created by Zhiliang
 * @Date 2023/10/3 21:50
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Component {
    String value() default "";
}
