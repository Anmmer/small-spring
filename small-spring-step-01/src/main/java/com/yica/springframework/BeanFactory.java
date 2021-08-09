package com.yica.springframework;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description:
 * @author:
 * @createDate: 2021/8/6
 */
public class BeanFactory {

    private final Map<String,BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String,BeanDefinition>();

    public Object getBean(String name){
       return beanDefinitionMap.get(name).getBean();
    }

    public void registerBeanDefinition(String name,BeanDefinition beanDefinition){
        this.beanDefinitionMap.put(name,beanDefinition);
    }
}
