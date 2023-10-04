package ren.beginner.springframework.test.bean;

import ren.beginner.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Created by Zhiliang
 * @Date 2023/10/4 17:48
 */
@Component
public class UserDao {

    private static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("10001", "Jzl，北京，亦庄");
        hashMap.put("10002", "Lzx，上海，尖沙咀");
        hashMap.put("10003", "Ssd，天津，东丽区");
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }

}
