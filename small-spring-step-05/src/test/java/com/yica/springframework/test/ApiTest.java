package com.yica.springframework.test;


import com.yica.springframework.beans.PropertyValue;
import com.yica.springframework.beans.PropertyValues;
import com.yica.springframework.beans.factory.config.BeanDefinition;
import com.yica.springframework.beans.factory.config.BeanReference;
import com.yica.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.yica.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import com.yica.springframework.test.bean.UserDao;
import com.yica.springframework.test.bean.UserService;
import org.junit.Test;

/**
 * @description:
 * @author:
 * @createDate: 2021/8/6
 */
public class ApiTest {

    @Test
    public void test_BeanFactory() {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. 读取配置文件&注册Bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        // 3. 获取Bean对象调用方法
        UserService userService = (UserService) beanFactory.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
    }


}
