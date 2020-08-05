package com.observer.repository.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.observer.repository.UrlShortenRepository;
import com.observer.util.DBUtil;

@Repository
public class UrlShorteningRepositoryImpl implements UrlShortenRepository {
	
	@Override
	public void save(String shortUrl, String longUrl) {
		
		DBUtil.save(shortUrl, longUrl);
		
	}

	@Override
	public String fetch(String shortUrl , Long clientId) {

		return DBUtil.fetch(shortUrl , clientId);
		
	}

	@Override
	public Map<String, Long> getStats() {
		
		return DBUtil.stats();
	}

}
