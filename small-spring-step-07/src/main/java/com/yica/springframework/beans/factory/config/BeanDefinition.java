package com.yica.springframework.beans.factory.config;

import com.yica.springframework.beans.PropertyValues;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @description:
 * @author:
 * @createDate: 2021/8/6
 */
@Data
public class BeanDefinition {

    private Class beanClass;

    private PropertyValues propertyValues;

    private String initMethodName;

    private String destroyMethodName;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
        this.propertyValues = new PropertyValues();
    }

    public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues == null ? new PropertyValues() : propertyValues;
    }

}
