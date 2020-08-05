package com.observer;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.security.NoSuchAlgorithmException;
import java.util.Map;

import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.observer.exception.AppRuntimeException;
import com.observer.repository.UrlShortenRepository;
import com.observer.request.USSRequest;
import com.observer.response.USSResponse;
import com.observer.service.impl.UrlShorteningServiceImpl;

@SpringBootTest
@RunWith(SpringRunner.class)
public class USSTest {

	@Mock
	private UrlShortenRepository urlShortenRepository;
	
	@InjectMocks
	private UrlShorteningServiceImpl urlShorteningService;
		
	@Test
	public void createShortUrlWithBlankRequest() throws NoSuchAlgorithmException{
		
		Exception exception = assertThrows(AppRuntimeException.class,
                () -> urlShorteningService.createShortenUrl(null, 123L));
        assertEquals("Url can not be blank", exception.getMessage());
		
	}
	
	@Test
	@Order(1)
	public void createShortUrl() throws NoSuchAlgorithmException{
		
		USSRequest request =  new USSRequest();
		request.setLongUrl("www.facebook.com");
		USSResponse response =  urlShorteningService.createShortenUrl(request, 123L);
        assertEquals("4d478ceb", response.getShortUrl());
		
	}
	
//	@Test
//	@Order(2)
//	public void getOriginalUrl() throws NoSuchAlgorithmException{
//		
//		createShortUrl();
//		String longUrl =  urlShorteningService.getOriginalUrl("4d478ceb", 123L);
//        
//		//assertNotNull(longUrl);
//		assertEquals("www.facebook.com", longUrl);
//		
//	}
	
	@Test
	public void stats() throws NoSuchAlgorithmException{
		
		Map<String,Long> response =  urlShorteningService.getStatus();
        
		assertNotNull(response);
		assertNotNull(response.entrySet());
		
	}
	
}
