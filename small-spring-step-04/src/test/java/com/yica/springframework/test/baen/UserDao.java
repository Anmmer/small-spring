package com.yica.springframework.test.baen;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author:
 * @createDate: 2021/8/10
 */
public class UserDao {

    private static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("10001", "小傅哥");
        hashMap.put("10002", "八杯水");
        hashMap.put("10003", "阿毛");
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }
}
