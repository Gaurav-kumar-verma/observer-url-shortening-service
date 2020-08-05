package com.observer.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import com.observer.exception.AppRuntimeException;
import com.observer.response.APIResponse;
import com.observer.response.ErrorObject;
import com.observer.util.ResponseUtil;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(AppRuntimeException.class)
	@ResponseBody
	public APIResponse<ErrorObject> HandleAppRunTimeException(HttpServletRequest request, HttpServletResponse response,
			AppRuntimeException e) {
		response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		ErrorObject errorObj = new ErrorObject(e.getMessage());
		return ResponseUtil.getErrorResponse(errorObj);
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public APIResponse<ErrorObject> HandleGenericException(HttpServletRequest request, HttpServletResponse response,
			Exception e) {
		response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		ErrorObject errorObj = new ErrorObject(e.getMessage());
		return ResponseUtil.getErrorResponse(errorObj);
	}

}
