package com.example.firstdemo.util;

import com.alibaba.fastjson.JSONObject;

public class JsonUtil {

    public static JSONObject getFailJsonObject(String string) {
        return JSONObject.parseObject(string);
    }

    public static JSONObject getSuccessJsonObject(String fileName) {
        return JSONObject.parseObject(fileName);
    }
}
