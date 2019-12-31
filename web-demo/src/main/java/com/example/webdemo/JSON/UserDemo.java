package com.example.webdemo.JSON;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * Created by duan on 2019/12/19 14:14
 */
@Data
@AllArgsConstructor
@ToString
public class UserDemo {

    @JsonProperty(value = "UserName")
    private String UserName;

    @JsonProperty(value = "PassWord")
    private String PassWord;
}
