package com.example.webdemo.enums;

import lombok.Getter;
import lombok.Setter;

public enum StatusEnums {

    SUCCESS(0, "请求成功"),
    SYSTEM_BUSY(-1,"系统繁忙"),
    SIGN_ERROR(4001,"签名错误"),
    TOKEN_ERROR(1,"非法的TokenCode"),
    PARAM_ERROR(4003, "参数错误"),
    SYSTEM_ERROR(500, "系统错误"),
    REDIS_CONNECT_ERROR(1,"系统错误"),
    METHOD_NOT_SUPPORT(1,"Request method 'GET' not supported"),
    TOKEN_CHECK_ERROR(5001,"TokenCode验证失败"),



    ACCOUNT_UNKNOWN(500, "账户不存在"),
    ACCOUNT_ERROR(500,"用户名或密码错误"),
    CODE_ERROR(400,"验证码错误"),
    PARAM_REPEAT(400, "参数已存在"),
    PERMISSION_ERROR(403, "没有操作权限"),
    OTHER(-100, "其他错误");

    @Getter
    @Setter
    private int code;
    @Getter
    @Setter
    private String info;

    StatusEnums(int code, String info) {
        this.code = code;
        this.info = info;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
