package com.observer.service;

import java.security.NoSuchAlgorithmException;
import java.util.Map;

import com.observer.request.USSRequest;
import com.observer.response.USSResponse;

public interface URLShorteningService {

	public USSResponse createShortenUrl(USSRequest request , Long clientId) throws NoSuchAlgorithmException;
	
	public String getOriginalUrl(String shortUrl , Long clientId);

	public Map<String,Long> getStatus();
	
}
