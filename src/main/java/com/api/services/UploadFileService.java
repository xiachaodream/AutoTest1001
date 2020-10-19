package com.api.services;

import com.api.utils.HttpClientUtil;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UploadFileService extends BaseService{
    public static void fileUpLoad() throws IOException {
        String url=myHost+mtx_fileUpLoadUrl;
        File file = new File("C:\\Users\\xiachao\\Pictures\\Camera Roll\\timg.jpg");
        HashMap<String, String> headsMap = new HashMap<>();
        headsMap.put("Content-Type","multipart/form-data");
        headsMap.put("","");
        headsMap.put("","");
        headsMap.put("","");
        CloseableHttpResponse response = HttpClientUtil.fileUpload(url, new FileInputStream(file), headsMap, "post");
        HttpEntity entity = response.getEntity();
        String result = EntityUtils.toString(entity);
        System.out.println(result);

    }

    public static void main(String[] args) throws IOException {
        fileUpLoad();
    }
}
