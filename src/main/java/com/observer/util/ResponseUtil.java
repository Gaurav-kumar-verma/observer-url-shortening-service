package com.observer.util;

import com.observer.response.APIResponse;

public class ResponseUtil {

	public static <T> APIResponse<T> getSuccessfulResponse(T t) {
        return (new APIResponse<T>(1, t));
    }
	
	public static <T> APIResponse<T> getErrorResponse(T errorObject) {
        return new APIResponse<T>(0, errorObject);
    }
	
}
