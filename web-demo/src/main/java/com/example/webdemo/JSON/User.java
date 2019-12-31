package com.example.webdemo.JSON;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    @JSONField(name = "UserName")
    private String userName;
    @JSONField(name = "PassWord")
    private String passWord;
}
