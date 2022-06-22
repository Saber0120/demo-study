package com.springboot.config;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sheng
 * @version 2021-11-18 15:27
 */
@Component
public class HttpUtil {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 调用一台机器
     *
     * @param httpUrl 服务地址
     * @return
     */
    public JSONObject doGet(String httpUrl) {
        JSONObject result = null;
        try {
            if (StringUtils.isNotBlank(httpUrl)) {
                result = restTemplate.getForEntity(httpUrl, JSONObject.class).getBody();
            }
            return result;
        } catch (ResourceAccessException e) {
            System.out.println("请求超时！");
        } catch (RestClientException e) {
            System.out.println("请求异常！");
        }
        return null;
    }

    /**
     * 调用一台机器
     *
     * @param httpUrl 服务地址
     * @return
     */
    public String doGetString(String httpUrl) {
        String result = null;
        try {
            if (StringUtils.isNotBlank(httpUrl)) {
                result = restTemplate.getForObject(httpUrl, String.class);
            }
            return result;
        } catch (ResourceAccessException e) {
            System.out.println("请求超时！");
        } catch (RestClientException e) {
            System.out.println("请求异常！");
        }
        return null;
    }

    /**
     * 调用一台机器
     *
     * @param httpUrl  服务地址
     * @param url      具体服务方法
     * @param postData 参数
     * @return
     */
    public List<JSONObject> doPost(String httpUrl, String url, JSONObject postData) {
        List<JSONObject> list = new ArrayList<JSONObject>();
        try {
            JSONObject result = null;
            if (StringUtils.isNotBlank(httpUrl)) {
                result = restTemplate.postForEntity(httpUrl + url, postData, JSONObject.class).getBody();
                list.add(result);
            }
        } catch (ResourceAccessException e) {
            System.out.println("请求超时！");
        } catch (RestClientException e) {
            System.out.println("请求异常！");
        }
        return null;
    }

    /**
     * 调用多台机器
     *
     * @param urlList  服务地址集合
     * @param method   具体服务方法
     * @param postData 参数
     * @return
     */
    public List<JSONObject> doPost(List<String> urlList, String method, JSONObject postData) {
        List<JSONObject> list = new ArrayList<JSONObject>();
        try {
            JSONObject result = null;
            if (urlList == null || urlList.size() == 0) {
                return null;
            }
            for (String url : urlList) {
                result = restTemplate.postForEntity(url + method, postData, JSONObject.class).getBody();
                list.add(result);
            }
        } catch (ResourceAccessException e) {
            System.out.println("请求超时！");
        } catch (RestClientException e) {
            System.out.println("请求异常！");
        }
        return null;
    }

    public ResponseEntity<String> doPostString(String httpUrl, String url, JSONObject postData) {
        try {
            if (StringUtils.isNotBlank(httpUrl)) {
                ResponseEntity<String> responseEntity = restTemplate.postForEntity(httpUrl + url, postData, String.class);
                return responseEntity;
            }
        } catch (ResourceAccessException e) {
            System.out.println("请求超时！");
        } catch (RestClientException e) {
            System.out.println("请求异常！");
        }
        return null;
    }

    public ResponseEntity<String> doPostStringCookie(String httpUrl, String url, JSONObject postData, List<String> cookies) {
        String cookie = cookies.get(0);
        UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(httpUrl).
                path(url).build(true);
        URI uri = uriComponents.toUri();
        RequestEntity<JSONObject> requestEntity = RequestEntity.post(uri).
                // 添加 cookie(这边有个问题，假如我们要设置 cookie 的生命周期，作用域等参数我们要怎么操作)
                        header(HttpHeaders.COOKIE, cookie).
                        body(postData);
        ResponseEntity<String> responseEntity = restTemplate.exchange(requestEntity, String.class);
        return responseEntity;
    }

    public ResponseEntity<String> doPostStringCookieForm(String httpUrl, String url, JSONObject postData, List<String> cookies, String message) {
        String cookie = cookies.get(0);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.set(HttpHeaders.COOKIE, cookie);
        HttpEntity<String> httpEntity = new HttpEntity<>(message, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(httpUrl + url, httpEntity, String.class);
        return response;
    }
}
