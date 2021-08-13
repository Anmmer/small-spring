package com.yica.springframework.context.support;

import com.yica.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.yica.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @description:
 * @author:
 * @createDate: 2021/8/12
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {

    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configLocations = getConfigLocations();
        if (null != configLocations){
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }

    protected abstract String[] getConfigLocations();
}
