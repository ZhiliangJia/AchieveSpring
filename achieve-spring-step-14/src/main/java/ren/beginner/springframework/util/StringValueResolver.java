package ren.beginner.springframework.util;

/**
 * 简单的策略接口，用于解决字符串值。
 *
 * @Created by Zhiliang
 * @Date 2023/10/4 13:54
 */
public interface StringValueResolver {
    /**
     * 解析给定的String值，例如解析占位符。
     *
     * @param strVal
     * @return
     */
    String resolveStringValue(String strVal);
}
