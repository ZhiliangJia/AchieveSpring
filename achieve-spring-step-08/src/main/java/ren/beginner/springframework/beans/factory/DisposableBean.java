package ren.beginner.springframework.beans.factory;

/**
 * 实现此接口的 Bean 对象，会在 BeanFactory 销毁是作出相应的处理。
 *
 * @Created by Zhiliang
 * @Date 2023/9/22 16:35
 */
public interface DisposableBean {
    /**
     * 销毁后执行的方法
     *
     * @throws Exception
     */
    void destroy() throws Exception;
}
