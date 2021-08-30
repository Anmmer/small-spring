package com.yica.springframework.test;


import com.yica.springframework.context.support.ClassPathXmlApplicationContext;
import com.yica.springframework.test.bean.UserService;
import org.junit.jupiter.api.Test;

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
        System.out.println("ApplicationContextAware："+userService.getApplicationContext());
        System.out.println("BeanFactoryAware："+userService.getBeanFactory());
    }

}
