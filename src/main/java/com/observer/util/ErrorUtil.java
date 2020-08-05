package com.observer.util;

import java.util.HashMap;
import java.util.Map;

public class ErrorUtil {
	
	public static final Map<String, String> ERROR_CODE_MAP = new HashMap<>();
	
	public static final String URL_BLANK = "USS001";
	
	public static final String URL_MAPPING_NOT_PRESENT = "USS002";
	
	static {
	    ERROR_CODE_MAP.put(URL_BLANK, "Url can not be blank");
	    ERROR_CODE_MAP.put(URL_MAPPING_NOT_PRESENT, "Url not present in System");
	}
	
	
	public static String getErrorMsg(String errorCode) {
        return ERROR_CODE_MAP.get(errorCode);
    }
	

}
