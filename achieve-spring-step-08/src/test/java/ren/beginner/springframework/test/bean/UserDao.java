package ren.beginner.springframework.test.bean;

import com.google.common.collect.ImmutableMap;

import java.util.HashMap;
import java.util.Map;

public class UserDao {
    private static Map<String, String> hashMap = new HashMap<>();

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }

    public void initDataMethod() {
        System.out.println("执行 init-method");
        hashMap = ImmutableMap.of("10001", "Jzl", "10002", "Ljz", "10003", "Zlj");
    }

    public void destroyDataMethod() {
        System.out.println("执行 destroy-method");
        // ImmutableMap不支持clear方法
        // hashMap.clear();
    }
}
