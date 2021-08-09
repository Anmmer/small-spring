package com.yica.springframework;

/**
 * @description:
 * @author:
 * @createDate: 2021/8/6
 */
public class BeanDefinition {
    private final Object bean;

    public BeanDefinition(Object bean){
        this.bean = bean;
    }

    public Object getBean(){
        return this.bean;
    }
}
