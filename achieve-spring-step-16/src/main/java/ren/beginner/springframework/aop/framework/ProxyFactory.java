package ren.beginner.springframework.aop.framework;

import ren.beginner.springframework.aop.AdvisedSupport;

/**
 * 这个代理工厂主要解决的是关于 JDK 和 Cglib 两种代理的选择问题，有了代理工厂就可以按照不同的创建需求进行控制。
 *
 * @Created by Zhiliang
 * @Date 2023/10/1 22:55
 */
public class ProxyFactory {
    /**
     * 管理和支持AOP代理的创建和配置。
     */
    private AdvisedSupport advisedSupport;

    public ProxyFactory(AdvisedSupport advisedSupport) {
        this.advisedSupport = advisedSupport;
    }

    public Object getProxy() {
        return createAopProxy().getProxy();
    }

    /**
     * 根据isProxyTargetClass判断采用何种代理方式
     *
     * @return
     */
    private AopProxy createAopProxy() {
        if (advisedSupport.isProxyTargetClass()) {
            return new Cglib2AopProxy(advisedSupport);
        }
        return new JdkDynamicAopProxy(advisedSupport);
    }
}
