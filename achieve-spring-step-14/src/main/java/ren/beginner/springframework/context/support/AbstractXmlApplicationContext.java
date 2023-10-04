package ren.beginner.springframework.context.support;

import ren.beginner.springframework.beans.factory.support.DefaultListableBeanFactory;
import ren.beginner.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * 用于｛@link cn.bugstack.springframework.context.ApplicationContext｝实现的方便基类，从
 * 包含｛@link-cn.bugstack.springframework.beans.factory.XML.XmlBeanDefinitionReader｝所理
 * 解的bean定义的XML文档中绘制配置。
 *
 * @Created by Zhiliang
 * @Date 2023/9/22 11:13
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {
    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configLocations = getConfigLocations();
        if (null != configLocations) {
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }

    /**
     * 获取Config File的路径
     *
     * @return
     */
    protected abstract String[] getConfigLocations();
}
