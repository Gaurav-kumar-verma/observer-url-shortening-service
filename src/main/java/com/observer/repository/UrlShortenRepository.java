package com.observer.repository;

import java.util.Map;

public interface UrlShortenRepository {

	public void save(String shortUrl , String longUrl);
	
	public String fetch(String shortUrl , Long cliendId);

	public Map<String, Long> getStats();
	
}
