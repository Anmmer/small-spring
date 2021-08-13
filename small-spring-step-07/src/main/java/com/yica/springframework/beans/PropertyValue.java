package com.yica.springframework.beans;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @description:
 * @author:
 * @createDate: 2021/8/10
 */
@Data
@AllArgsConstructor
public class PropertyValue {

    private String name;

    private Object value;

}
