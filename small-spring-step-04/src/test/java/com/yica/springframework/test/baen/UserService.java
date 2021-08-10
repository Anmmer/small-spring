package com.yica.springframework.test.baen;

/**
 * @description:
 * @author:
 * @createDate: 2021/8/6
 */
public class UserService {

    private String uId;

    private UserDao userDao;

    public void queryUserInfo(){
        System.out.println("查询用户信息"+userDao.queryUserName(uId));
    }
}
