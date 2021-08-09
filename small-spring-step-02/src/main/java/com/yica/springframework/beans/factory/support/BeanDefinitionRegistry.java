package com.yica.springframework.beans.factory.support;

import com.yica.springframework.beans.factory.config.BeanDefinition;

/**
 * @description:
 * @author:
 * @createDate: 2021/8/6
 */
public interface BeanDefinitionRegistry {

    /**
     *  向注册表中注册 BeanDefinition
     * @Param: beanName, beanDefinition
     * @Return: void
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
