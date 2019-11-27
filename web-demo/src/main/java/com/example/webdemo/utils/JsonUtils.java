package com.example.webdemo.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class JsonUtils {
    //将某一对象转换为json字符串并返回前台
    public static void responseJson(Object obj) {
        // fastjson 全局配置
        // string null -> ""
        JSON.DEFAULT_GENERATE_FEATURE |= SerializerFeature.WriteNullStringAsEmpty.getMask();
        // number null -> 0
        JSON.DEFAULT_GENERATE_FEATURE |= SerializerFeature.WriteNullNumberAsZero.getMask();
        // list null -> []
        JSON.DEFAULT_GENERATE_FEATURE |= SerializerFeature.WriteNullListAsEmpty.getMask();
        // boolean null -> false     |=按位或赋值操作符  C | = 2等价于C = C | 2
        JSON.DEFAULT_GENERATE_FEATURE |= SerializerFeature.WriteNullBooleanAsFalse.getMask();

        HttpServletResponse response = ((ServletRequestAttributes) (RequestContextHolder.getRequestAttributes())).getResponse();
        response.setContentType("text/json;charset=utf-8");
        String jsonString = JSON.toJSONString(obj);
        try {
            log.info("方法的返回值为：{}",jsonString);
            response.getWriter().write(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
