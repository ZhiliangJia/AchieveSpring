package ren.beginner.springframework.beans;

/**
 * 自定义的默认异常
 *
 * @Created by Zhiliang
 * @Date 2023/9/21 15:36
 */
public class BeansException extends RuntimeException {

    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
