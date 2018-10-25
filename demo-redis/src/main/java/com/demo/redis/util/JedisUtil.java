package com.demo.redis.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by sheng on 2018/10/25.
 */
public class JedisUtil {

    private JedisPoolConfig jedisPoolConfig;

    private String host;

    private Integer port;

    private String pwd;

    private Integer timeOut;

    private String clientName;

    private JedisPool jedisPool;

    public void setJedisPoolConfig(JedisPoolConfig jedisPoolConfig) {
        this.jedisPoolConfig = jedisPoolConfig;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setTimeOut(Integer timeOut) {
        this.timeOut = timeOut;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    private void buildConnection() {
        if (jedisPool == null) {
            if (jedisPoolConfig == null) {
                jedisPool = new JedisPool(new JedisPoolConfig(), host, port, timeOut, pwd, 0, clientName);
            } else {
                jedisPool = new JedisPool(jedisPoolConfig, host, port, timeOut, pwd, 0, clientName);
            }
        }
    }

    public Jedis getJedis() {
        buildConnection();
        if (jedisPool != null) {
            return jedisPool.getResource();
        }
        return null;
    }
}
