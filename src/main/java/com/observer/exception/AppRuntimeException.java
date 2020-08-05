package com.observer.exception;

import com.observer.util.ErrorUtil;

public class AppRuntimeException extends RuntimeException {

	private static final long serialVersionUID = -8245765926747595137L;

	private String code;
	
	private String msg;
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public AppRuntimeException(String code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}

    public AppRuntimeException(String code) {
        super(ErrorUtil.getErrorMsg(code));
        this.code = code;
        this.msg = ErrorUtil.getErrorMsg(code);
    }
	
}
