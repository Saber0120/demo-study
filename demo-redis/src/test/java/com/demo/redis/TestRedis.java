package com.demo.redis;

import com.demo.redis.util.JedisUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sheng on 2018/10/25.
 */
public class TestRedis {

    private JedisUtil jedisUtil;

    @Before
    public void before() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(50);
        jedisPoolConfig.setMaxIdle(10);
        jedisPoolConfig.setMinIdle(1);
        jedisUtil = new JedisUtil();
        jedisUtil.setHost("127.0.0.1");
        jedisUtil.setPort(6379);
        jedisUtil.setClientName(Thread.currentThread().getName());
        jedisUtil.setTimeOut(600);
        jedisUtil.setJedisPoolConfig(jedisPoolConfig);
    }

    @Test
    public void testSetGet() {
        Jedis jedis = jedisUtil.getJedis();
        String key = "setGet";
        String value = "setGetValue";
        jedis.set(key, value);
        Assert.assertEquals(value, jedis.get(key));
    }

    @Test
    public void testGetRange() {
        Jedis jedis = jedisUtil.getJedis();
        String key = "getRange";
        String value = "getRangeValue";
        jedis.set(key, value);
        // redis的range是前包后包的
        // Java中String的substring是前包后不包的
        Assert.assertEquals(value.substring(1, 3), jedis.getrange(key, 1,2));
    }

    @Test
    public void testGetSet() {
        Jedis jedis = jedisUtil.getJedis();
        String key = "getSet";
        String value = key + "Value";
        String value2 = value + "2";
        jedis.set(key, value);
        // getSet设置新值，获取old值
        Assert.assertEquals(value, jedis.getSet(key, value2));
        Assert.assertEquals(value2, jedis.get(key));
    }

    @Test
    public void testMGet() {
        Jedis jedis = jedisUtil.getJedis();
        String key = "mget";
        String key1 = key + "1";
        String key2 = key + "2";
        String value = key + "Value";
        String value1 = key1 + "Value";
        String value2 = key2 + "Value";
        jedis.mset(key, value, key1, value1, key2, value2);
        List<String> mgetList = jedis.mget(key, key1, key2);
        List<String> strList = new ArrayList<>();
        strList.add(value);
        strList.add(value1);
        strList.add(value2);
        Assert.assertEquals(mgetList, strList);
    }
}
