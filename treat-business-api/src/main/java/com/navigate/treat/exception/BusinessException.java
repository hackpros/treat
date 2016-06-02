package com.navigate.treat.exception;

/**
 * 业务异常
 * 
 * @author fanwg
 * @date 2013-7-22 下午05:05:10
 * @email renntrabbit@foxmail.com
 */
public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String code;

	private String message;

	public BusinessException() {
	}

	public BusinessException(String msg) {
		// super(code);
		//从缓存里倒对象牙误代码对应的message
		//this.message = ExceptionCodeConstants.getMessage(code);
		this.message=msg;
	}

	public BusinessException(Throwable cause) {
		super(cause);
	}

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}

	public BusinessException(String code, String message) {
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