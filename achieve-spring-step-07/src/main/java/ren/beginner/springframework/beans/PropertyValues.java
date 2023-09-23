package ren.beginner.springframework.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * bean 属性信息的组合
 *
 * @Created by Zhiliang
 * @Date 2023/9/21 15:36
 */
public class PropertyValues {
    /**
     * bean对象所有的属性值
     */
    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    public void addPropertyList(PropertyValue value) {
        this.propertyValueList.add(value);
    }

    public PropertyValue[] getPropertyValues() {
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }

    public PropertyValue getPropertyValue(String propertyName) {
        for (PropertyValue propertyValue : this.propertyValueList) {
            if (propertyValue.getName().equals(propertyName)) {
                return propertyValue;
            }
        }
        return null;
    }
}
