package ren.beginner.springframework.beans.factory;

import ren.beginner.springframework.beans.BeansException;
import ren.beginner.springframework.beans.PropertyValue;
import ren.beginner.springframework.beans.PropertyValues;
import ren.beginner.springframework.beans.factory.config.BeanDefinition;
import ren.beginner.springframework.beans.factory.config.BeanFactoryPostProcessor;
import ren.beginner.springframework.core.io.DefaultResourceLoader;
import ren.beginner.springframework.core.io.Resource;
import ren.beginner.springframework.core.io.ResourceLoader;

import java.io.IOException;
import java.util.Properties;

/**
 * 依赖于 BeanFactoryPostProcessor 在 Bean 生命周期的属性，可以在 Bean 对象实例化之前，改变属性信息。
 *
 * @Created by Zhiliang
 * @Date 2023/10/3 21:16
 */
public class PropertyPlaceholderConfigurer implements BeanFactoryPostProcessor {
    /**
     * 填充置位符前缀：${@value}
     */
    public static final String DEFAULT_PLACEHOLDER_PREFIX = "${";
    /**
     * 填充置位符后缀：${@value}
     */
    public static final String DEFAULT_PLACEHOLDER_SUFFIX = "}";

    private String location;

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        try {
            DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
            Resource resource = resourceLoader.getResource(location);
            Properties properties = new Properties();
            properties.load(resource.getInputStream());

            String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
            for (String beanName : beanDefinitionNames) {
                BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanName);

                PropertyValues propertyValues = beanDefinition.getPropertyValues();
                for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
                    Object value = propertyValue.getValue();
                    if (!(value instanceof String)) {
                        continue;
                    }

                    String strVal = (String) value;
                    StringBuilder builder = new StringBuilder(strVal);
                    int startIdx = strVal.indexOf(DEFAULT_PLACEHOLDER_PREFIX);
                    int stopIdx = strVal.indexOf(DEFAULT_PLACEHOLDER_SUFFIX);
                    if (startIdx != -1 && stopIdx != -1 && startIdx < stopIdx) {
                        String propKey = strVal.substring(startIdx + 2, stopIdx);
                        String propVal = properties.getProperty(propKey);
                        builder.replace(startIdx, stopIdx + 1, propVal);
                        propertyValues.addPropertyList(new PropertyValue(propertyValue.getName(), builder.toString()));
                    }
                }
            }
        } catch (IOException e) {
            throw new BeansException("Could not load properties", e);
        }
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
