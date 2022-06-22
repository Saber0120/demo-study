package com.springboot;

import com.alibaba.fastjson.JSONObject;
import com.springboot.config.HttpUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.MessageFormat;
import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoSpringbootApplicationTests {

    @Autowired
    private HttpUtil httpUtil;

    @Test
    public void contextLoads() {
    }

    String url = "http://www.chengci.net:7003";
    String login = "/Login/CheckLogin";
    String realtime = "/ReportModule/DataGather/LoadDataGather";
    String history = "/ReportModule/SamplingData/LoadSamplingData";
    String equipList = "/ReportModule/LineChart/LoadEquipment";
    // String equipId = "95";
    String equipId = "77";
    // String equipId = "16777265";
    String cookie = "13C2C1A702AE2DE0685599534B4EF79BE230E087C8C8E8A11193847134EC3DEA41E88EF055442C7CAAE452E503F9F9A70278D0FE59B998335D8A89430E22DFFC4EC5159CD3F52A64AC170001F1F7EC8C23ED747EC6757FA5B9C50D1FFEF279F49E7575FAED88D3BC81E4CA7171DA4CE5F1F11E896C784F159BAF8385C818AA5EDF917F0F14B3C77A456CB61EC9D2C3F636D491A77A03BC5834773DBE486B9BE413557D4FB0FEB027142B7D69F836AC15BFD227CEE571E3D482CF3FC09AA7DE820F355C23BD13C7E210E5D1572973B18721DFA04BA08500DCAB2B8F0008A1EA3D8AA5DC02842FBDC028D8B1B2F2348E3A0EEE7B44152533B211C4F3BB16FBD26D451E6B94AFFAC70E1A499579B49B53257FA8C39633B9B48E7517FDAAF77313AD808BA85D092B0DDD2DEC3CC272884943F261C9AE1BA62E93D46D83B6213C0CA387375D5EAD59B4341694B682133600CFD0F92148E518512C56E3C259A96497CD9BBA41D2E1D08947931B16297ED422C9B1A417EA0DBC5644FC899CE07B06767D240D2769629FCBF8BBCD3A5565133D9B743820F0EC34A283D39DF8910EE30358AA9F0DBFB1BDA1502E330EB5ED611D2951F52BEDB856D4C5FD693FC150679A07E9A7C72AF6488FDAAAA1868CB2A360CA3B28CE11B3AD195BE7D9DFAE0AC006EAA8F5966F52E56875E15F584A2B186FB5";

    @Test
    public void testRestTemplate() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Account", "zhongyu003");
        jsonObject.put("Password", "96e79218965eb72c92a549dd5a330112");
        ResponseEntity<String> responseEntity = httpUtil.doPostString(url, login, jsonObject);
        List<String> cookies = responseEntity.getHeaders().get(HttpHeaders.COOKIE);
    }

    @Test
    public void testRestTemplate2() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Account", "zhongyu003");
        jsonObject.put("Password", "96e79218965eb72c92a549dd5a330112");
        ResponseEntity<String> responseEntity = httpUtil.doPostString(url, login, jsonObject);
        List<String> cookies = responseEntity.getHeaders().get("Set-Cookie");

        jsonObject = new JSONObject();
        // jsonObject.put("SequenceNumber", equipId);
        responseEntity = httpUtil.doPostStringCookie(url, realtime, jsonObject, cookies);
        System.out.println(responseEntity.getBody());
    }

    @Test
    public void testRestTemplate3() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Account", "zhongyu003");
        jsonObject.put("Password", "96e79218965eb72c92a549dd5a330112");
        ResponseEntity<String> responseEntity = httpUtil.doPostString(url, login, jsonObject);
        List<String> cookies = responseEntity.getHeaders().get("Set-Cookie");

        String message = MessageFormat.format("page={0}&rows={1}&sidx={2}&sord={3}", "1", "10", "exampletime", "desc");
        responseEntity = httpUtil.doPostStringCookieForm(url, history + "?SequenceNumber=" + equipId + "&StartTime=2022-06-22 16:01:30&EndTime=2022-06-22 16:16:30", jsonObject, cookies, message);
        System.out.println(responseEntity.getBody());
    }

    @Test
    public void testRestTemplate4() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Account", "zhongyu003");
        jsonObject.put("Password", "96e79218965eb72c92a549dd5a330112");
        ResponseEntity<String> responseEntity = httpUtil.doPostString(url, login, jsonObject);
        List<String> cookies = responseEntity.getHeaders().get("Set-Cookie");

        jsonObject = new JSONObject();
        responseEntity = httpUtil.doPostStringCookie(url, equipList, jsonObject, cookies);
        System.out.println(responseEntity.getBody());
    }
}
