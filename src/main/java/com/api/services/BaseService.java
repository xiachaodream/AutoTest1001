package com.api.services;

import com.api.utils.PropertyUtil;

import java.util.Properties;


public class BaseService{
    public static String myHost=null;
    public static String mtx_loginUrl=null;
    public static String mtx_fileUpLoadUrl=null;
    static {
        Properties properties = PropertyUtil.loadProps("property/login.properties");
        myHost = properties.getProperty("myHost");
        mtx_loginUrl = properties.getProperty("mtx_loginUrl");
        mtx_fileUpLoadUrl = properties.getProperty("mtx_fileUpLoadUrl");
    }


}
