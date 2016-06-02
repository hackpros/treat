package com.navigate.treat.cache;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;

public class JedisClusterUtilTest {
	Jedis jc = null;
    @Before
    public void before(){
        Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
        //Jedis Cluster will attempt to discover cluster nodes automatically
        jedisClusterNodes.add(new HostAndPort("121.40.172.165",6379));
        jc = new Jedis("121.40.172.165",6379);
        jc.auth("123456");
    }
    @Test
    public void test_incr(){

        String key = "page_view";
        jc.del(key);
        jc.incr(key);
        String result = jc.get(key);
        System.out.println(result);
        Assert.assertEquals(result,1+"");
    }
    @Test
    public void test_setAndGetStringVal(){
        String key = "foo";
        String value = "bar";
        jc.set(key, value);
        String result = jc.get(key);
        System.out.println(result);
        Assert.assertEquals(result,value);
    }
    @Test
    public void test_setAndGetStringVal_and_set_expire() throws InterruptedException{
        String key = "hello";
        String value = "world";
        int seconds = 3;
        jc.setex(key, seconds , value);
        String result = jc.get(key);
        System.out.println(result);
        Assert.assertEquals(result,value);
        Thread.sleep(seconds*1000);
        result = jc.get(key);
        System.out.println(result);
        Assert.assertEquals(result,null);

    }
    @Test
    public void test_setAndGetHashVal(){

        String key = "website";
        String field= "google";
        String value = "google.com";
        jc.del(key);
        jc.hset(key, field, value);
        String result = jc.hget(key, field);
        System.out.println(result);
         Assert.assertEquals(result,value);
    }
    @Test
    public void test_setAndGetListVal(){

        String key = "mylist";
        jc.del(key);
        String[] vals = {"a","b","c"};
        jc.rpush(key, vals);
        List<String> result = jc.lrange(key, 0, -1);
        System.out.println(result);
         Assert.assertEquals(result,vals);
    }
    @Test
    public void test_setAndGetSetVal(){

        String key = "language";
        jc.del(key);
        String[] members = {"java", "ruby", "python"};
        jc.sadd(key, members);
        Set<String> result = jc.smembers(key);
        System.out.println(result);
         Assert.assertEquals(result,members);
    }

}
