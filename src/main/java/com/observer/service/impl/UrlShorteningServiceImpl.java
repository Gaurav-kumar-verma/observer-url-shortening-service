package com.observer.service.impl;

import java.security.NoSuchAlgorithmException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.observer.exception.AppRuntimeException;
import com.observer.repository.UrlShortenRepository;
import com.observer.request.USSRequest;
import com.observer.response.USSResponse;
import com.observer.service.URLShorteningService;
import com.observer.util.AppUtil;
import com.observer.util.ErrorUtil;

@Service
public class UrlShorteningServiceImpl implements URLShorteningService {

	
	@Autowired
	private UrlShortenRepository urlShortenRepository;
	
	@Override
	public USSResponse createShortenUrl(USSRequest request, Long clientId) throws NoSuchAlgorithmException {
		
		if(null == request || null == request.getLongUrl()){
			throw new AppRuntimeException(ErrorUtil.URL_BLANK);
		}
		
		String longUrl = request.getLongUrl();
		// convert into short URL
		String shortUrl = AppUtil.convertToShortUrl(longUrl);
		urlShortenRepository.save(shortUrl, longUrl);
		
		return new USSResponse(shortUrl);
	}

	@Override
	public String getOriginalUrl(String shortUrl, Long clientId) {

		if(null == shortUrl){
			throw new AppRuntimeException(ErrorUtil.URL_BLANK);
		}
		
		return urlShortenRepository.fetch(shortUrl , clientId);
		
	}

	@Override
	public Map<String,Long> getStatus() {
		
		return urlShortenRepository.getStats();
	}

}
