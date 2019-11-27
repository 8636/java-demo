package com.example.webdemo.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author duan
 * @version 1.0
 * @date 2019/11/26 20:12
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO {
    @JSONField(name = "RetCode")
    private String RetCode;
    @JSONField(name = "RetMsg")
    private String RetMsg;
}
