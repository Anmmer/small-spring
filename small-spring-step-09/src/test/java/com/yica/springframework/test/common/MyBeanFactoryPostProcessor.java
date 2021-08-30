package com.yica.springframework.test.common;

import com.yica.springframework.beans.BeansException;
import com.yica.springframework.beans.PropertyValue;
import com.yica.springframework.beans.PropertyValues;
import com.yica.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.yica.springframework.beans.factory.config.BeanDefinition;
import com.yica.springframework.beans.factory.config.BeanFactoryPostProcessor;

/**
 * @description:
 * @author:
 * @createDate: 2021/8/12
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();

        propertyValues.addPropertyValue(new PropertyValue("company", propertyValues.getPropertyValue("company").getValue()+"改为：字节跳动"));
    }
}
