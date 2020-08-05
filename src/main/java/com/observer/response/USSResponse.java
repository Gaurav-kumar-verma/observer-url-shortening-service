package com.observer.response;

public class USSResponse {

	private String shortUrl;
	
	private long expiresAt;

	public USSResponse(String url) {
		super();
		this.shortUrl = url;
	}

	public USSResponse(String shortUrl, long expiresAt) {
		super();
		this.shortUrl = shortUrl;
		this.expiresAt = expiresAt;
	}

	public String getShortUrl() {
		return shortUrl;
	}

	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}

	public long getExpiresAt() {
		return expiresAt;
	}

	public void setExpiresAt(long expiresAt) {
		this.expiresAt = expiresAt;
	}
	
}
