package com.yica.springframework.beans.factory.support;

import com.yica.springframework.beans.BeansException;
import com.yica.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @description:
 * @author:
 * @createDate: 2021/8/6
 */
public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException;

}
