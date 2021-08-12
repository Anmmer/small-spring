package com.yica.springframework.context;

import com.yica.springframework.beans.BeansException;

public interface ConfigurableApplicationContext extends ApplicationContext {

    /**
     * 刷新容器
     *
     * @param
     * @return: void
     * @throws:
     */
    void refresh() throws BeansException;
}
