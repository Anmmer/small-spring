package com.yica.springframework.test;


import com.yica.springframework.beans.factory.config.BeanDefinition;
import com.yica.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.yica.springframework.test.baen.UserService;
import org.junit.Test;

/**
 * @description:
 * @author:
 * @createDate: 2021/8/6
 */
public class ApiTest {

    @Test
    public void test_BeanFactory() {
        //1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        //2.注册 bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService",beanDefinition);

        //3.获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }

}
