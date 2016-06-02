package com.navigate.treat.cache;

/**
 * redis 服务异常的时候
 * 
 * @author hsp
 * 
 */
public class RedisException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7548999587337586754L;

	public RedisException(String message) {
		super(message);
	}

	public RedisException(String message, Throwable throwable) {
		super(message, throwable);
	}

}