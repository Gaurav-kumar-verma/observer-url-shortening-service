package com.observer.controller;

import java.security.NoSuchAlgorithmException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.observer.request.USSRequest;
import com.observer.response.APIResponse;
import com.observer.response.USSResponse;
import com.observer.service.URLShorteningService;
import com.observer.util.ResponseUtil;

@RestController
@RequestMapping("/url/")
public class URLController {

	@Autowired
	private URLShorteningService urlShorteningService;
	
	@RequestMapping(value="/shorten" , method=RequestMethod.POST , produces=MediaType.APPLICATION_JSON_VALUE)
	public APIResponse<USSResponse> createShortUrl(@RequestBody USSRequest request , @RequestParam Long clientId) throws NoSuchAlgorithmException{
		
		return ResponseUtil.getSuccessfulResponse(urlShorteningService.createShortenUrl(request, clientId));
		
	}
	
	@RequestMapping(value="/{url}" , method=RequestMethod.GET , produces=MediaType.APPLICATION_JSON_VALUE)
	public APIResponse<String> createShortUrl(@PathVariable(value="url") String shortUrl , @RequestParam Long clientId) {
		
		return ResponseUtil.getSuccessfulResponse(urlShorteningService.getOriginalUrl(shortUrl, clientId));
		
	}
	
	@RequestMapping(value="/stats" , method=RequestMethod.GET , produces=MediaType.APPLICATION_JSON_VALUE)
	public APIResponse<Map<String,Long>> createShortUrl() {
		
		return ResponseUtil.getSuccessfulResponse(urlShorteningService.getStatus());
		
	}
	
}
