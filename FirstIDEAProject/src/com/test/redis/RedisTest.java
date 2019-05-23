package com.test.redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisTest {
    @Test
    public void jedisTest(){
       Jedis jd = new Jedis("192.168.121.132",6379);

       //获取数据
        System.out.println(jd.get("sex"));

        //保存数据
       jd.set("name","老男人");
        System.out.println(jd.get("name"));
    }

    @Test
    public void testRedisPool(){
        //配置连接池对象
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(30);//设置最大空闲数
        jedisPoolConfig.setMaxTotal(10);//设置最大连接数

        //获取连接池对象
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, "192.168.121.132", 6379);
        Jedis jedis = jedisPool.getResource();
        //使用连接池操作数据
        //jedis.set("name","w8");
        System.out.println(jedis.get("name"));
    }


    public String toString2() {
        return "v1";
    }


}



