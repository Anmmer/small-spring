package com.yica.springframework.test.common;

import com.yica.springframework.beans.BeansException;
import com.yica.springframework.beans.factory.config.BeanPostProcessor;
import com.yica.springframework.test.bean.UserService;

/**
 * @description:
 * @author:
 * @createDate: 2021/8/12
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("userService".equals(beanName)) {
            UserService userService = (UserService) bean;
            userService.setLocation(userService.getLocation()+"改为：北京");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
