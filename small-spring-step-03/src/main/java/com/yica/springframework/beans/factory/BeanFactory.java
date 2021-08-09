package com.yica.springframework.beans.factory;

import com.yica.springframework.beans.BeansException;

public interface BeanFactory {

    Object getBean(String beanName);

    Object getBean(String name, Object... args) throws BeansException;
}
