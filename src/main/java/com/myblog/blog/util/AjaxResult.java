
package com.myblog.blog.util;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
@Data
@AllArgsConstructor
public class AjaxResult<T> {
    private Integer code;//状态码
    private String msg;//提示
    private boolean success;//成功
    private T data;//数据

    //请求成功
    public AjaxResult() {
        this.code = 200;
        this.success = true;
        this.msg = "请求成功";
    }

    //请求成功,返回提示
    public AjaxResult(String msg) {
        this.code = 200;
        this.success = true;
        this.msg = msg;
    }

    //请求成功,返回数据
    public AjaxResult(T data) {
        this.code = 200;
        this.success = true;
        this.msg = "请求成功";
        this.data = data;
    }

    //请求成功,返回提示和数据
    public AjaxResult(String msg, T data) {
        this.code = 200;
        this.success = true;
        this.msg = msg;
        this.data = data;
    }

    //请求不成功,返回提示语错误码
    public AjaxResult(String msg, Integer code) {
        this.code = code;
        this.msg = msg;
        this.success = false;
    }
}

