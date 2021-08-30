package com.yica.springframework.test.bean;

import com.yica.springframework.beans.factory.DisposableBean;
import com.yica.springframework.beans.factory.InitializingBean;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @description:
 * @author:
 * @createDate: 2021/8/6
 */
@Getter
@Setter
public class UserService {

    private String uId;

    private String company;

    private String location;

    private IUserDao userDao;


    public String queryUserInfo(){

        return "查询用户信息"+userDao.queryUserName(uId)+ "," + company + "," + location;
    }

}
