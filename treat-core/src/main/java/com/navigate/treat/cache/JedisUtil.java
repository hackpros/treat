package com.navigate.treat.cache;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import com.alibaba.fastjson.JSON;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 生成一个JedisCluster实例
 * @author fwg create by  2016年3月30日 下午6:10:00
 *	
 */
public class JedisUtil {
	private static final Logger logger = LogManager.getLogger(JedisUtil.class);
	
	private static Jedis jc;

	static {
		try {
			Properties properties = PropertiesLoaderUtils.loadAllProperties("global.properties");
			String hostAndPorts = properties.getProperty("redis.cluster.hostAndPorts");
			String auth=properties.getProperty("redis.auth");
			Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
			String[] hostAndPortArray = hostAndPorts.split(",");
			String[] str={};
			for (String hostAndPort : hostAndPortArray) {
			    str = hostAndPort.split(":");
				jedisClusterNodes.add(new HostAndPort(str[0], Integer.parseInt(str[1])));
			}
			// pool中最大持有对象数
			int maxTotal = Integer.parseInt(properties.getProperty("redis.cluster.maxTotal"));
			// pool中最大空闲对象数
			int maxIdle = Integer.parseInt(properties.getProperty("redis.cluster.maxIdle"));
			// 获取redis对象的timeout时间
			//int timeout = Integer.parseInt(properties.getProperty("redis.cluster.timeout"));
			// 配置jedisPool
			JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
			jedisPoolConfig.setMaxTotal(maxTotal);
			jedisPoolConfig.setMaxIdle(maxIdle);
			jc = new Jedis(str[0], Integer.parseInt(str[1]));
			jc.auth(auth);
			logger.info("Redis连接主机:" + jedisClusterNodes);
		} catch (Exception e) {
			logger.error(e);
			throw new RuntimeException("redis load error");
		}
	}
	public static Jedis getJedis() {
		return jc;
	}
	/**
	 * 获取redis里的json对象，转换为对象
	 * @param key
	 * @return Object
	 * @since p2p_cloud_v1.0
	 */
	public static <T> T getObject(String key, Class<T> clazz) {
		String jsonObject = jc.get(key);
		if (StringUtils.isEmpty(jsonObject))
			return null;
		return JSON.parseObject(jsonObject, clazz);
	}
	/**
	 * 获取redis里的json对象，转换为对象
	 * @param key
	 * @return Object
	 * @since p2p_cloud_v1.0
	 */
	public static String  get(String key) {
		String jsonObject = jc.get(key);
		if (StringUtils.isEmpty(jsonObject))
			return null;
		return JSON.parseObject(jsonObject, String.class);
	}
	/**
	 * 获取list对象
	 * @param key
	 * @param clazz
	 * @return List<T>
	 * @since p2p_cloud_v1.0
	 */
	public static <T> List<T> getList(String key, Class<T> clazz) {
		String jsonObject = jc.get(key);
		if (StringUtils.isEmpty(jsonObject)) {
			return new ArrayList<T>();
		}
		return JSON.parseArray(jsonObject, clazz);
	}
	public static void save(String key, Object value) throws RedisException {
		if (value == null)
			return;
		save(key,15, JSON.toJSONString(value));
		
	}
	public static void save(String key, int expirationTime, Object value) {
		if (value == null)
			return;
		jc.setex(key, expirationTime, JSON.toJSONString(value));
	}
	public static void del(String key) {
		jc.del(key);
	}
	public static void move(String key) {
		jc.move(key, 1);
	}
	public static byte[] getKey(String key) {
		return key.getBytes();
	}
	/**
	 * 从变量 +1 操作
	 */
	public static Long incr(String key) {
		Long val = jc.incr(key);
		return val;
	}
	public static boolean exists(String key) {
		return jc.exists(key);
	}
	public static void expire(String key, int expirationTime) {
		jc.expire(key, expirationTime);
	}
	/**
	 * 方法：返回列表的长度
	 * @param key
	 * @return
	 */
	/**
	 * 方法：对象序列化逆向
	 * @param bytes
	 * @return
	 */
	public static Object byte2Object(byte[] bytes) {
		if (bytes == null || bytes.length == 0)
			return null;
		try {
			ObjectInputStream inputStream;
			inputStream = new ObjectInputStream(new ByteArrayInputStream(bytes));
			Object obj = inputStream.readObject();
			return obj;
		} catch (IOException e) {
			logger.error("Object CacheUtil.byte2Object is called,catch IOException:", e);
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			logger.error("Object CacheUtil.byte2Object is called,catch ClassNotFoundException:", e);
			e.printStackTrace();
		}
		return null;
	}
	public Object byte2ObjectNoV(byte[] bytes) {
		if (bytes == null || bytes.length == 0)
			return null;
		try {
			ObjectInputStream inputStream;
			inputStream = new ObjectInputStream(new ByteArrayInputStream(bytes));
			Object obj = inputStream.readObject();
			return obj;
		} catch (IOException e) {
			logger.error("Object CacheUtil.byte2ObjectNoV is called,catch IOException:", e);
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			logger.error("Object CacheUtil.byte2ObjectNoV is called,catch ClassNotFoundException:", e);
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 方法：对象序列化
	 * @param value
	 * @return
	 */
	public static byte[] object2Bytes(Object value) {
		if (value == null)
			return null;
		ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
		ObjectOutputStream outputStream;
		try {
			outputStream = new ObjectOutputStream(arrayOutputStream);
			outputStream.writeObject(value);
		} catch (IOException e) {
			logger.error("byte[] CacheUtil.object2Bytes is called,catch IOException:", e);
			e.printStackTrace();
		} finally {
			logger.error("byte[] CacheUtil.object2Bytes is called,catch finally Exception");
			try {
				arrayOutputStream.close();
			} catch (IOException e) {
				logger.error("byte[] CacheUtil.object2Bytes is called,catch IOException:", e);
				e.printStackTrace();
			}
		}
		return arrayOutputStream.toByteArray();
	}
}
