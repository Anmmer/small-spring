package com.yica.springframework.beans.factory.support;

import com.yica.springframework.beans.BeansException;
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

    /**
     * 使用Bean名称查询BeanDefinition
     *
     * @param beanName
     * @return
     * @throws BeansException
     */
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * 判断是否包含指定名称的BeanDefinition
     * @param beanName
     * @return
     */
    boolean containsBeanDefinition(String beanName);

    /**
     * Return the names of all beans defined in this registry.
     *
     * 返回注册表中所有的Bean名称
     */
    String[] getBeanDefinitionNames();
}
