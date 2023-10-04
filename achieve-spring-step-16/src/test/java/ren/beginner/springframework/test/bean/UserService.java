package ren.beginner.springframework.test.bean;

import ren.beginner.springframework.beans.factory.annotation.Autowired;
import ren.beginner.springframework.beans.factory.annotation.Value;
import ren.beginner.springframework.stereotype.Component;

import java.util.Random;

/**
 * @Created by Zhiliang
 * @Date 2023/9/30 23:43
 */
public class UserService implements IUserService {
    private String token;

    public String queryUserInfo() {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Jzl，100001，深圳，" + token;
    }

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
