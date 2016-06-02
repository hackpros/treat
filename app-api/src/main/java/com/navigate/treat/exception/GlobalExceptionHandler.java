package com.navigate.treat.exception;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.navigate.treat.exception.modelview.ExceptionResponse;

@ControllerAdvice
public class GlobalExceptionHandler {
	private static final Logger logger = LogManager.getLogger(GlobalExceptionHandler.class.getName());
	//登录会活无效
	private static final int HttpStatus_SESSION_INVALID = 432;

	/**
	 * 其它异常拦截
	 * @param e
	 * @param response
	 * @return
	 */
	@ExceptionHandler(value = { Throwable.class })
	@ResponseBody
	public ExceptionResponse handleCommonException(Throwable e, HttpServletResponse response) {
		logger.error(e.getCause(), e);
		if (e.getMessage() != null && e.getMessage().contains("com.navigate.treat.")) {
			response.setStatus(HttpStatus.CONFLICT.value());
			return ExceptionResponse.create(String.valueOf(HttpStatus.CONFLICT.value()), "业务处理异常");
		}
		response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		return ExceptionResponse.create(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()), "系统错误");
	}
	/**
	 * 业务异常拦截
	 * @param response
	 * @param e
	 * @return
	 * @throws IOException
	 */
	@ExceptionHandler(value = BusinessException.class)
	@ResponseStatus(value = HttpStatus.CONFLICT)
	@ResponseBody
	public ExceptionResponse handleBusinessException(HttpServletResponse response, BusinessException e)
			throws IOException {
		logger.error(e.getCause(), e);
		return ExceptionResponse.create(HttpStatus.CONFLICT.value() + "", e.getMessage());
	}
	/**
	 * 参数异常拦截
	 * @param response
	 * @param e
	 * @return
	 * @throws IOException
	 */
	@ExceptionHandler(value = ParamValidateException.class)
	@ResponseStatus(value = HttpStatus.CONFLICT)
	@ResponseBody
	public ExceptionResponse handleParamValidateException(HttpServletResponse response, ParamValidateException e)
			throws IOException {
		logger.error(e.getCause(), e);
		return ExceptionResponse.create(e.getCode(), e.getMessage());
	}
	/**
	 * 会话异常拦截
	 * @param response
	 * @param e
	 * @return
	 * @throws IOException
	 */
	@ExceptionHandler(value = SessionException.class)
	@ResponseBody
	public ExceptionResponse handleSessionException(HttpServletResponse response, SessionException e)
			throws IOException {
		logger.error(e.getCause(), e);
		response.setStatus(HttpStatus_SESSION_INVALID);
		return ExceptionResponse.create(HttpStatus_SESSION_INVALID+"", e.getMessage());
	}
	/*
	 * @ExceptionHandler(value = {Exception.class}) public ResponseEntity<Object>
	 * handleOtherExceptions(final Exception ex, final WebRequest req) { TResult tResult = new
	 * TResult(); tResult.setStatus(CodeType.V_500); tResult.setErrorMessage(ex.getMessage());
	 * return new ResponseEntity<Object>(tResult,HttpStatus.OK); }
	 */
}
