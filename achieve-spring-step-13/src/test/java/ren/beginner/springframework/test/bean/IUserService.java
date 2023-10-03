package ren.beginner.springframework.test.bean;

/**
 * @Created by Zhiliang
 * @Date 2023/9/30 23:43
 */
public interface IUserService {
    String queryUserInfo();

    String register(String userName);
}
