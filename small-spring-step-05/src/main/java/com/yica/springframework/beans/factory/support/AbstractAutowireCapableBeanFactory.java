package com.yica.springframework.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import com.yica.springframework.beans.BeansException;
import com.yica.springframework.beans.PropertyValue;
import com.yica.springframework.beans.PropertyValues;
import com.yica.springframework.beans.factory.config.BeanDefinition;
import com.yica.springframework.beans.factory.config.BeanReference;

import java.lang.reflect.Constructor;

/**
 * @description:
 * @author:
 * @createDate: 2021/8/6
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    private final InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) {
        Object bean;
        try {
            bean = createBeanInstance(beanDefinition, beanName, args);
            // 给 Bean 填充属性
            applyPropertyValues(beanName, bean, beanDefinition);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        addSingleton(beanName, bean);
        return bean;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) {
        Constructor constructorToUse = null;
        Class<?> beanClass = beanDefinition.getBeanClass();
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        for (Constructor ctor : declaredConstructors) {
            if (null != args && ctor.getParameterTypes().length == args.length) {
                constructorToUse = ctor;
            }
        }
        return instantiationStrategy.instantiate(beanDefinition, beanName, constructorToUse, args);
    }

    /**
     * bean填充
     *
     * @Param: [beanName, bean, beanDefinition]
     * @Return: void
     */
    protected void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
                String name = propertyValue.getName();
                Object value = propertyValue.getValue();

                if (value instanceof BeanReference) {
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }
                BeanUtil.setFieldValue(bean, name, value);
            }
        } catch (Exception e) {
            throw new BeansException("Error setting property values：" + beanName);
        }
    }
}
