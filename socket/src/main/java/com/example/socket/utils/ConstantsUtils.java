package com.example.socket.utils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConstantsUtils {
    public static int SYS_APP_WEIXIN=20;
    public static String LX_TOKEN = "";
    //朗新配置参数
    public static String LX_OPERATORID;
    public static String LX_OPERATOR_SECRET;
    public static String LX_DATA_SECRET;
    public static String LX_DATA_SECRETIV;
    public static String LX_SIG_SECRET;
    public static String LX_URL;
    //腾龙配置参数
    public static String TL_OPERATORID;
    public static String TL_OPERATOR_SECRET;
    public static String TL_DATA_SECRET;
    public static String TL_DATA_SECRETIV;
    public static String TL_SIG_SECRET;
    public static String TL_URL;
    //访问蔡工后台参数，去拿朗新接口需要的数据
    public static String USERPROXY_IP;
    public static String USERPROXY_PORT;

    //socket服务器
    public static String SOCKETSERVER_IP;
    public static String SOCKETSERVER_PORT;

    //redis
    public static String REDIS_IP;
    public static String REDIS_PORT;
    public static String REDIS_PASSWORD;
    public static Map<String,String> ActionMap;

    public static Map<String,String> needPushStopChargeMap;
    public static Map<String,String> needPushOrderMap;
    public static Map<String,String> connectIDToTaskIDMap;

    public static ConcurrentHashMap<String,String> pushStartChargeMap = new ConcurrentHashMap<>();

    public static ConcurrentHashMap<String,String> pushStartChargeStatusMap = new ConcurrentHashMap<>();
}
