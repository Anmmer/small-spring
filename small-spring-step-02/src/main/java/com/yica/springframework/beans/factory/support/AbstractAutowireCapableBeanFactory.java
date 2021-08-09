package com.yica.springframework.beans.factory.support;

import com.yica.springframework.beans.BeansException;
import com.yica.springframework.beans.factory.config.BeanDefinition;

/**
 * @description:
 * @author:
 * @createDate: 2021/8/6
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    protected Object createBean(String beanName, BeanDefinition beanDefinition) {
        Object bean;
        try {
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (IllegalAccessException | InstantiationException e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        addSingleton(beanName, bean);
        return bean;
    }
}
