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
    public void test_BeanFactory() {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. 读取配置文件&注册Bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring_postProcessor.xml");
//        reader.loadBeanDefinitions("classpath:spring_small.xml");

        // 3. BeanDefinition 加载完成 & Bean实例化之前，修改 BeanDefinition 的属性值
        MyBeanFactoryPostProcessor beanFactoryPostProcessor = new MyBeanFactoryPostProcessor();
        beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);

        // 4. Bean实例化之后，修改 Bean 属性信息
        MyBeanPostProcessor beanPostProcessor = new MyBeanPostProcessor();
        beanFactory.addBeanPostProcessor(beanPostProcessor);

        // 5. 获取Bean对象调用方法
        UserService userService = beanFactory.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
    }

    @Test
    public void test_xml() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring_postProcessor.xml");
        // 2. 获取Bean对象调用方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
    }


}
