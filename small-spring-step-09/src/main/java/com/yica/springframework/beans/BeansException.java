package com.yica.springframework.beans;

/**
 * @description:
 * @author:
 * @createDate: 2021/8/6
 */
public class BeansException extends RuntimeException {

    public BeansException(String msg){
        super(msg);
    }

    public BeansException(String msg,Throwable cause){
        super(msg,cause);
    }

}
