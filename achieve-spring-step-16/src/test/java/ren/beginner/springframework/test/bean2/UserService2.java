package ren.beginner.springframework.test.bean2;

import ren.beginner.springframework.beans.factory.annotation.Autowired;
import ren.beginner.springframework.beans.factory.annotation.Value;
import ren.beginner.springframework.stereotype.Component;

import java.util.Random;

/**
 * @Created by Zhiliang
 * @Date 2023/10/4 22:32
 */
@Component
public class UserService2 implements IUserService2 {

    @Value("${token}")
    private String token;

    @Autowired
    private UserDao2 userDao2;

    @Override
    public String queryUserInfo() {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return userDao2.queryUserName("10001") + token;
    }

    @Override
    public String register(String userName) {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "注册用户：" + userName + " success！";
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
