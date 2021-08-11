package com.yica.springframework.test.bean;

/**
 * @description:
 * @author:
 * @createDate: 2021/8/6
 */
public class UserService {

    private String uId;

    private UserDao userDao;

    public String queryUserInfo(){

        return "查询用户信息"+userDao.queryUserName(uId);
    }
}
