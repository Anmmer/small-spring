package com.yica.springframework.context;

import com.yica.springframework.beans.BeansException;
import com.yica.springframework.beans.factory.Aware;

/**
 * @description: Interface to be implemented by any object that wishes to be notifiedof the {@link ApplicationContext} that it runs in.
 * 实现此接口，既能感知到所属的 ApplicationContext
 * @author: yica
 * @createDate: 2021/8/24
 */
public interface ApplicationContextAware extends Aware {

    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;

}
