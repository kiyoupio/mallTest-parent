package com.yangpai.conmon.component;

import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * 统一返回类
 *
 * @author kuangyoupeng1
 * @date 2022.02.09
 */
public class ApiResult<T> implements Serializable {

    /**
     * 状态值
     */
    private Integer code;

    /**
     * 返回信息
     */
    private String message;

    /**
     * 返回数据
     */
    private T data;

    public ApiResult(Integer code, String message, T data) {
        this.setCode(code);
        this.setMessage(message);
        this.setData(data);
    }
    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * getter必须得加，因为底层转Json的时候需要用到get（反射）
     * @return
     */
    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public static <T> ApiResult<T> success() {
        return new ApiResult(HttpStatus.OK.value(), null, null);
    }

    public static <T> ApiResult<T> success(T data) {
        return new ApiResult(HttpStatus.OK.value(), null, data);
    }

    public static <T> ApiResult<T> success(String msg) {
        return new ApiResult(HttpStatus.OK.value(), msg, null);
    }

    public static <T> ApiResult<T> success(String msg, T data) {
        return new ApiResult(HttpStatus.OK.value(), msg, data);
    }

    public static <T> ApiResult<T> error() {
        return new ApiResult(HttpStatus.INTERNAL_SERVER_ERROR.value(), null, null);
    }

    public static <T> ApiResult<T> error(T data) {
        return new ApiResult(HttpStatus.INTERNAL_SERVER_ERROR.value(), null, data);
    }

    public static <T> ApiResult<T> error(String msg) {
        return new ApiResult(HttpStatus.INTERNAL_SERVER_ERROR.value(), msg, null);
    }

    public static <T> ApiResult<T> error(String message, T data) {
        return new ApiResult(HttpStatus.INTERNAL_SERVER_ERROR.value(), message, data);
    }

    public static <T> ApiResult<T> error(Integer code) {
        return new ApiResult(code, null, null);
    }

    public static <T> ApiResult<T> error(Integer code, String message) {
        return new ApiResult(code, message, null);
    }

    public static <T> ApiResult<T> error(Integer code, String message, T data) {
        return new ApiResult(code, message, data);
    }
}
