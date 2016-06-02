package com.navigate.treat.exception;

/**
 * 
 * @author fanwg
 * @date 2013-7-22 下午05:05:10
 * @email renntrabbit@foxmail.com
 */
public class SessionException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String code;

	private String message;

	public SessionException() {
	}

	public SessionException(String msg) {
		this.message=msg;
	}

	public SessionException(Throwable cause) {
		super(cause);
	}

	public SessionException(String message, Throwable cause) {
		super(message, cause);
	}

	public SessionException(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
