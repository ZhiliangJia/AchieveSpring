package ren.beginner.springframework.beans.factory.annotation;

import java.lang.annotation.*;

/**
 * 自动装配时，可以在字段或参数上使用此注释作为候选bean的限定符。它还可以用于注释其他自定义注释，然后将其用作限定符。
 *
 * @Created by Zhiliang
 * @Date 2023/10/4 15:46
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Qualifier {
    /**
     * bean名称
     *
     * @return
     */
    String value() default "";
}
