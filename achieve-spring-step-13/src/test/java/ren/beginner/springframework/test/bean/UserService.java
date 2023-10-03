package ren.beginner.springframework.test.bean;

import java.util.Random;

/**
 * @Created by Zhiliang
 * @Date 2023/9/30 23:43
 */
public class UserService implements IUserService {
    @Override
    public String queryUserInfo() {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "Jzl，100001，沈阳";
    }

    @Override
    public String register(String userName) {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "注册用户：" + userName + " success！";
    }
}
