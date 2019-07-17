package com.example.demo.pojo;

public class ApiResponse<T> {

    private Integer code;

    private String message;

    private T data;

    public ApiResponse(Integer code, String msg, T data) {
        this.code = code;
        this.message = msg;
        this.data = data;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return this.code;
    }

    public void setMessage(String msg) {
        this.message = msg;
    }

    public String getMessage() {
        return this.message;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return this.data;
    }
}
