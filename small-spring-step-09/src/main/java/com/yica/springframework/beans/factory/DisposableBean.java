package com.yica.springframework.beans.factory;

public interface DisposableBean {

    void destroy() throws Exception;

}
