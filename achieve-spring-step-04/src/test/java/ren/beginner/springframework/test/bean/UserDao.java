package ren.beginner.springframework.test.bean;

import com.google.common.collect.ImmutableMap;

import java.util.Map;

public class UserDao {
    private static Map<String, String> hashMap = ImmutableMap.of("10001", "Jzl", "10002", "Ljz", "10003", "Zlj");

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }
}
