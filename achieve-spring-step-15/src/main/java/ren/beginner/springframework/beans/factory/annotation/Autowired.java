package ren.beginner.springframework.beans.factory.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 将构造函数、字段、setter方法或config方法标记为由Spring的依赖注入工具自动连接。
 *
 * @Created by Zhiliang
 * @Date 2023/10/4 15:36
 */
@Target({ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Autowired {
}
