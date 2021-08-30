package com.yica.springframework.beans.factory;

/**
 * @description: Interface to be implemented by beans that want to be aware of their bean name in a bean factory.
 *              实现此接口，既能感知到所属的 BeanName
 * @author: yica
 * @createDate: 2021/8/24
 */
public interface BeanNameAware extends Aware {

    void setBeanName(String name);

}
