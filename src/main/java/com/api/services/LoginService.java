package com.api.services;

import com.api.utils.HttpClientUtil;
import com.api.utils.PropertyUtil;

import java.util.HashMap;
import java.util.Map;

public class LoginService extends BaseService{
    public static String login(String account, String pwd, Map<String,String> heads){
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("accounts",account);
        paramMap.put("pwd",pwd);
        String url=myHost+mtx_loginUrl;
        System.out.println(url);
        String result = HttpClientUtil.postForm(url, paramMap, heads);
        System.out.println(result);
        return result;
    }
}
