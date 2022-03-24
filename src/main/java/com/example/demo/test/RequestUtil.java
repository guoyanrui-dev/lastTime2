package com.example.demo.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author guoyanrui on 2022/3/24
 */
public class RequestUtil {
    //sendpost
    public JSONObject sendPost(String url, Map<String, String> param, Map<String, String> header) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        List<NameValuePair> list = new ArrayList<>();
        param.forEach((key, value) -> {
            list.add(new BasicNameValuePair(key, value));
        });
        httpPost.setEntity(new UrlEncodedFormEntity(list, "utf-8"));
        header.forEach((headerkey, headervalue) -> {
            httpPost.setHeader(headerkey, headervalue);
        });
        CloseableHttpResponse execute = client.execute(httpPost);
        String string = EntityUtils.toString(execute.getEntity());
        return JSON.parseObject(string);
    }
    //sendget
    public void sendGet(String url) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse execute = client.execute(httpGet);
        String string = EntityUtils.toString(execute.getEntity());
        System.out.println(string);
    }

    public static void main(String[] args) throws IOException {
        new RequestUtil().sendGet("http://baidu.com");
    }
}
