package ren.beginner.springframework.context;

import ren.beginner.springframework.beans.factory.HierarchicalBeanFactory;
import ren.beginner.springframework.beans.factory.ListableBeanFactory;
import ren.beginner.springframework.core.io.ResourceLoader;

/**
 * 为应用程序提供配置的中央接口。当应用程序运行时，这是只读的，但如果实现支持，则可能会重新加载。
 *
 * @Created by Zhiliang
 * @Date 2023/9/22 11:15
 */
public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader, ApplicationEventPublisher {

}
