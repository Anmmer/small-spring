package com.yica.springframework.test.bean;

import com.yica.springframework.beans.BeansException;
import com.yica.springframework.beans.factory.*;
import com.yica.springframework.context.ApplicationContext;
import com.yica.springframework.context.ApplicationContextAware;
import lombok.Data;

/**
 * @description:
 * @author:
 * @createDate: 2021/8/6
 */
@Data
public class UserService implements BeanNameAware, BeanClassLoaderAware, ApplicationContextAware, BeanFactoryAware {

    private ApplicationContext applicationContext;
    private BeanFactory beanFactory;

    private String uId;
    private String company;
    private String location;
    private UserDao userDao;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Bean Name is：" + name);
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("ClassLoader：" + classLoader);
    }


    public String queryUserInfo(){

        return "查询用户信息"+userDao.queryUserName(uId)+ "," + company + "," + location;
    }
}
