package ren.beginner.springframework.context.support;

import ren.beginner.springframework.beans.BeansException;

/**
 * 独立的XML应用程序上下文，从类路径中获取上下文定义文件，将普通路径解释为包括包路径的类路
 * 径资源名称（例如“mypackage/myresource.txt”）。对于测试工具以及嵌入JAR中的应用程序上下文都很有用。
 *
 * @Created by Zhiliang
 * @Date 2023/9/22 11:15
 */
public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext {
    /**
     * 配置文件的location
     */
    private String[] configLocations;

    public ClassPathXmlApplicationContext() {
    }

    public ClassPathXmlApplicationContext(String configLocation) throws BeansException {
        this(new String[]{configLocation});
    }

    public ClassPathXmlApplicationContext(String[] configLocations) throws BeansException {
        this.configLocations = configLocations;
        refresh();
    }

    @Override
    protected String[] getConfigLocations() {
        return configLocations;
    }
}
