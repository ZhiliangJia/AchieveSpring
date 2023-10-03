package ren.beginner.springframework.context.annotation;

import cn.hutool.core.util.ClassUtil;
import ren.beginner.springframework.beans.factory.config.BeanDefinition;
import ren.beginner.springframework.stereotype.Component;
import ren.beginner.springframework.utils.ClassUtils;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 从指定的基本包开始扫描候选组件的组件提供程序。
 *
 * @Created by Zhiliang
 * @Date 2023/10/3 21:53
 */
public class ClassPathScanningCandidateComponentProvider {

    /**
     * 从BasePackage中扫描Component
     *
     * @param basePackage
     * @return
     */
    public Set<BeanDefinition> findCandidateComponents(String basePackage) {
        Set<BeanDefinition> candidates = new LinkedHashSet<>();
        Set<Class<?>> classes = ClassUtil.scanPackageByAnnotation(basePackage, Component.class);
        for (Class<?> clazz : classes) {
            candidates.add(new BeanDefinition(clazz));
        }
        return candidates;
    }
}
