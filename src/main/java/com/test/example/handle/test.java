package com.test.example.handle;

import com.alibaba.fastjson.JSON;
import com.test.example.server.Utils;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {

        String prefix = "tracker_OV0wP8gR";
        String date = LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE);

        String name = "mp1906111";
        String campaign = "mp1906111   ";

        System.out.println(campaign.equalsIgnoreCase(name));


    }

    public static List strToList(String str, List<String> defaultVal) {
        if (null == str)
            return defaultVal;
        try {
            return JSON.parseArray(str, String.class);
        } catch (Exception ex) {
            return defaultVal;
        }
    }


    public static boolean checkProxy() {


        return false;
    }
}
