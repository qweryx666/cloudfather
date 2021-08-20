package com.yang.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lenovo
 * @description 这里封装的是我们返回给前端的一些状态信息、json数据、说明等
 * @date 2021/7/14 9:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T data;

    /**
     *
     * @param code
    	 * @param message
     * @return
     * @author legion
     * @creed: 可能data是null，所以定义了一个两个参数的构造方法
     * @date 2021/7/14 9:59
     */
    public CommonResult(Integer code, String message){
        this(code,message,null);
    }
}
