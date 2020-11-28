package com.api.utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HttpClientUtil {
    private static Logger logger = Logger.getLogger(HttpClientUtil.class);
    public static HttpClient client;
    static{
        client=HttpClients.createDefault();
    }
    public static String get(String url,Map<String,String> heads){
        logger.info(url);
        logger.info(heads);
        String result = null;
        HttpGet httpGet = new HttpGet(url);
        if(!heads.isEmpty()){
            for(Map.Entry<String,String> entry :heads.entrySet()){
                httpGet.setHeader(entry.getKey(),entry.getValue());
            }
        }
        try {
            HttpResponse response = client.execute(httpGet);
            HttpEntity entity = response.getEntity();
            result = EntityUtils.toString(entity,"utf-8");
            logger.info(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String postForm(String url, Map<String,Object> params,Map<String,String> heads){
        logger.info(url);
        logger.info(heads);
        logger.info(params);
        String result=null;
        HttpPost httpPost = new HttpPost(url);
        List<BasicNameValuePair> basicNameValuePairs = new ArrayList<>();
        if(!params.isEmpty()){
            for(Map.Entry<String,Object> entry:params.entrySet() ){
                String key = entry.getKey();
                Object value = entry.getValue();
                BasicNameValuePair basicNameValuePair = new BasicNameValuePair(key, (String) value);
                basicNameValuePairs.add(basicNameValuePair);
            }
        }
        if(!heads.isEmpty()){
            for(Map.Entry<String,String> entry :heads.entrySet()){
                httpPost.setHeader(entry.getKey(),entry.getValue());
            }
        }
        try {
            UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(basicNameValuePairs);
            httpPost.setEntity(urlEncodedFormEntity);
            HttpResponse response = client.execute(httpPost);
            result = EntityUtils.toString(response.getEntity());
            logger.info(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;

    }

    public static String postJson(String url,String json) {
        logger.info(url);
        logger.info(json);
        String result=null;
        HttpPost httpPost = new HttpPost(url);
        StringEntity entity = new StringEntity(json,"utf-8");
        httpPost.setEntity(entity);
        httpPost.setHeader("content-type","application/json");
        HttpResponse response = null;
        try {
            response = client.execute(httpPost);
            result = EntityUtils.toString(response.getEntity());
            logger.info(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static CloseableHttpResponse fileUpload(String url, InputStream inputStream,Map<String,String> heads,String type) throws IOException {
        CloseableHttpClient httpClient;
        if(type.equals("post")){
            HttpPost httpPost = new HttpPost(url);
            if(!heads.isEmpty()){
                for(Map.Entry<String,String> entry :heads.entrySet()){
                    httpPost.setHeader(entry.getKey(),entry.getValue());
                }
            }
            InputStreamEntity inputStreamEntity = new InputStreamEntity(inputStream);
            httpPost.setEntity(inputStreamEntity);
            httpClient= HttpClients.createDefault();
            return httpClient.execute(httpPost);
        }else if(type.equals("put")){
            HttpPut httpPut = new HttpPut(url);
            if(!heads.isEmpty()){
                for(Map.Entry<String,String> entry :heads.entrySet()){
                    httpPut.setHeader(entry.getKey(),entry.getValue());
                }
            }
            InputStreamEntity inputStreamEntity = new InputStreamEntity(inputStream);
            httpPut.setEntity(inputStreamEntity);
            httpClient= HttpClients.createDefault();
            return httpClient.execute(httpPut);
        }
        return null;
    }

    public void fileUpLoadPostFrom(){

    }





}
