package com.yica.springframework.test.bean;

import com.yica.springframework.beans.factory.DisposableBean;
import com.yica.springframework.beans.factory.InitializingBean;
import lombok.Data;

/**
 * @description:
 * @author:
 * @createDate: 2021/8/6
 */
@Data
public class UserService implements InitializingBean, DisposableBean {

    private String uId;

    private String company;

    private String location;

    private UserDao userDao;

    @Override
    public void destroy() throws Exception {
        System.out.println("执行：UserService.destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("执行：UserService.afterPropertiesSet");
    }


    public String queryUserInfo(){

        return "查询用户信息"+userDao.queryUserName(uId)+ "," + company + "," + location;
    }
}
