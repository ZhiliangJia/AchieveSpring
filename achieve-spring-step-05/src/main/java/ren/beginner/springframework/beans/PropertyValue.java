package ren.beginner.springframework.beans;

/**
 * bean 属性信息
 *
 * @Created by Zhiliang
 * @Date 2023/9/21 15:36
 */
public class PropertyValue {
    /**
     * 属性名
     */
    private final String name;
    /**
     * 属性值
     */
    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
