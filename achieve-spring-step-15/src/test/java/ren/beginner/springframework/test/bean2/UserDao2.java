package ren.beginner.springframework.test.bean2;

import ren.beginner.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Created by Zhiliang
 * @Date 2023/10/4 22:32
 */
@Component
public class UserDao2 {

    private static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("10001", "Jzl，北京，亦庄");
        hashMap.put("10002", "Xza，香港，九龙");
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }
}
