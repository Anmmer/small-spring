package com.yica.springframework.test.bean;

import lombok.Data;

/**
 * @description:
 * @author:
 * @createDate: 2021/8/6
 */
@Data
public class UserService {

    private String uId;

    private String company;

    private String location;

    private UserDao userDao;

    public String queryUserInfo(){

        return "查询用户信息"+userDao.queryUserName(uId)+ "," + company + "," + location;
    }
}
