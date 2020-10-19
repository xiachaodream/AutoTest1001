package com.api.study;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HttpClientStudy {
    @Test
    public void getDemo() throws IOException {
        HttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("https://www.cnfuzheng.com/home/goods.do?type=0&content=%25E7%25AC%2594");
        HttpResponse response = client.execute(httpGet);
        String result = EntityUtils.toString(response.getEntity());
        System.out.println(result);
    }

    @Test
    public void postDemo() throws IOException {
        HttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("https://www.cnfuzheng.com/home/goods.do?type=0&content=%25E7%25AC%2594");
        BasicNameValuePair name = new BasicNameValuePair("name","张三");
        BasicNameValuePair password = new BasicNameValuePair("password","张三");
        List<BasicNameValuePair> params = new ArrayList<>();
        params.add(name);
        params.add(password);
        UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(params);
        httpPost.setEntity(urlEncodedFormEntity);
        HttpResponse response = client.execute(httpPost);
        String result = EntityUtils.toString(response.getEntity());
        System.out.println(result);
    }

    @Test
    public void postJsonDemo() throws IOException {
        HttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("https://www.cnfuzheng.com/home/goods.do?type=0&content=%25E7%25AC%2594");
        StringEntity entity = new StringEntity("{\"id\":\"1\"}","utf-8");
        httpPost.setEntity(entity);
        httpPost.setHeader("content-type","application/json");
        HttpResponse response = client.execute(httpPost);
        String result = EntityUtils.toString(response.getEntity());
        System.out.println(result);
    }

    @Test
    public void postxmlDemo() throws IOException {
        HttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx");
        String xml="<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                "  <soap:Body>\n" +
                "    <getMobileCodeInfo xmlns=\"http://WebXml.com.cn/\">\n" +
                "      <mobileCode>18698587191</mobileCode>\n" +
                "      <userID></userID>\n" +
                "    </getMobileCodeInfo>\n" +
                "  </soap:Body>\n" +
                "</soap:Envelope>";
        HttpEntity entity = new StringEntity(xml,"utf-8");
        httpPost.setEntity(entity);
        httpPost.setHeader("Content-Type","text/xml;charset=utf-8");
        HttpResponse response = client.execute(httpPost);
        System.out.println(response.getStatusLine().getStatusCode());
        String result = EntityUtils.toString(response.getEntity());
        System.out.println(result);
    }

    @Test
    public void uploadDemo() throws IOException {
        HttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("https://notarybackend.cloud.alipay.com/api/web/file/create_upload_url");
        MultipartEntityBuilder.create();

    }
}
