package com.yica.springframework.test;


import com.yica.springframework.beans.PropertyValue;
import com.yica.springframework.beans.PropertyValues;
import com.yica.springframework.beans.factory.config.BeanDefinition;
import com.yica.springframework.beans.factory.config.BeanReference;
import com.yica.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.yica.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import com.yica.springframework.context.support.ClassPathXmlApplicationContext;
import com.yica.springframework.test.bean.UserDao;
import com.yica.springframework.test.bean.UserService;
import com.yica.springframework.test.common.MyBeanFactoryPostProcessor;
import com.yica.springframework.test.common.MyBeanPostProcessor;
import org.junit.Test;

/**
 * @description:
 * @author:
 * @createDate: 2021/8/6
 */
public class ApiTest {


    @Test
    public void test_xml() {

        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();

        // 2. 获取Bean对象调用方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
    }


}
