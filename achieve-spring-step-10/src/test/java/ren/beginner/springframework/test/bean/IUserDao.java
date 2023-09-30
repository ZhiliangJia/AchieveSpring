package ren.beginner.springframework.test.bean;

/**
 * @Created by Zhiliang
 * @Date 2023/9/29 21:38
 */
public interface IUserDao {
    /**
     * 获取用户名字
     *
     * @param uId
     * @return
     */
    String queryUserName(String uId);
}
