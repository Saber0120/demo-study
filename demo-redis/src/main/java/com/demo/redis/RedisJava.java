package com.demo.redis;

import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sheng on 2018/10/25.
 */
public class RedisJava {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功！");
        System.out.println("服务正在运行：" + jedis.ping());
        System.out.println();

        String key = "stringkey";
        jedis.set(key, "str1");
        System.out.println(key + " : " + jedis.get(key));
        System.out.println();

        key = "listkey";
        int start = 0;
        int end = 10;
        String[] arrays = {"abc", "def", "ghi"};
        List<String> listValues = Arrays.asList(arrays);
        for (String s : listValues) {
            jedis.lpush(key, s);
        }
        List<String> lrange = jedis.lrange(key, start, end);
        lrange.forEach(o -> System.out.println("list项：" + o));
        System.out.println();


    }
}
