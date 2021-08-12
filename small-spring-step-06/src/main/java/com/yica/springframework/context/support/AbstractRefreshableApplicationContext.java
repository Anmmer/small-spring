package com.yica.springframework.context.support;

import com.yica.springframework.beans.BeansException;
import com.yica.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.yica.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @description:
 * @author:
 * @createDate: 2021/8/12
 */
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext {

    private DefaultListableBeanFactory beanFactory;

    @Override
    protected void refreshBeanFactory() throws BeansException {
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
    }

    private DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }

    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);

    @Override
    protected ConfigurableListableBeanFactory getBeanFactory() {
        return beanFactory;
    }
}
