package com.test.example.server;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;


public class Utils {
    private static final Logger logger = LoggerFactory.getLogger(Utils.class.getName());

    public static boolean isEmptyStr(String str) {
        return str == null || str.trim().isEmpty();
    }

    public static boolean isNotEmptyStr(String str) {
        return str != null && str.trim().length() > 0;
    }

    public static long strToLong(String ts, long defaultVal) {
        if (isEmptyStr(ts))
            return defaultVal;
        try {
            return Long.parseLong(ts);
        } catch (Exception ex) {
            logger.error("str to long failed, {}, use default:{}", ts, defaultVal);
            return defaultVal;
        }
    }

    public static String getStrDefault(String str, String defaultVal) {
        if (isEmptyStr(str)) {
            return defaultVal;
        }
        return str;
    }

    public static int strToInt(String is, int defaultVal) {
        if (isEmptyStr(is))
            return defaultVal;
        try {
            return Integer.parseInt(is);
        } catch (Exception ex) {
            logger.error("str to int failed, {}, use default:{}", is, defaultVal);
            return defaultVal;
        }
    }

    public static int strToInt(String is) {
        return strToInt(is, 0);
    }

    public static float strToFloat(String is, float defaultVal) {
        if (isEmptyStr(is))
            return defaultVal;
        try {
            return Float.parseFloat(is);
        } catch (Exception ex) {
            logger.error("str to int failed, {}use default:{}", is, defaultVal);
            return defaultVal;
        }
    }

    public static Map<String, String> strToMap(String str, Map<String, String> defaultVal) {
        if (isEmptyStr(str))
            return defaultVal;
        try {
            return JSON.parseObject(str, Map.class);
        } catch (Exception ex) {
            return defaultVal;
        }
    }

    public static List strToListMap(String str, List<Map<String, String>> defaultVal) {
        if (isEmptyStr(str))
            return defaultVal;
        try {
            return JSON.parseArray(str, Map.class);
        } catch (Exception ex) {
            return defaultVal;
        }
    }
}
