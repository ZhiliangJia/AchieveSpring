package ren.beginner.springframework.beans.factory.config;


/**
 * 表示对类型的bean引用，例如<tt>@foo</tt>或<tt>@'foo.bar'</tt>.对于FactoryBean，语法<tt>&foo</tt>可用于访问工厂本身。
 *
 * @Created by Zhiliang
 * @Date 2023/9/21 15:36
 */
public class BeanReference {
    /**
     * bean的名称
     */
    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
