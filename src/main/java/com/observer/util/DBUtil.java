package com.observer.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.observer.exception.AppRuntimeException;

public class DBUtil {
	
	private static  Map<String,List<Long>> urlStatus = new HashMap<>();

	private static Map<String,String> urlMap =  new HashMap<>();
	
	private static Map<String,Long> stats =  new HashMap<>();
	
	public static void save(String shortUrl , String longUrl){
		
		urlMap.put(shortUrl , longUrl);
		
	}
	
	public static String fetch(String shortUrl , Long clientId) {
		String originalUrl = urlMap.get(shortUrl);
		List<Long> clientIds =  urlStatus.get(originalUrl);
		
		if(null == originalUrl)
			throw new AppRuntimeException(ErrorUtil.URL_MAPPING_NOT_PRESENT);
			
		if(null == clientIds)
			clientIds =  new ArrayList<Long>();
		
		if(!clientIds.contains(clientId)){
			if(stats.get(originalUrl) == null){
				stats.put(originalUrl,1L);
			} else {
				stats.put(originalUrl, stats.get(originalUrl)+1);
			}
			clientIds.add(clientId);
			urlStatus.put(originalUrl, clientIds);
		}
		
		return originalUrl;
		
	}
	
	public static Map<String,Long> stats() {
		
		return stats;
	}
	
}
