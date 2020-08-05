package com.observer.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.DatatypeConverter;

public class AppUtil {

	
	private static String base64Charset = "abcdefghijklmnopqrstuvwxyz.ABCDEFGHIJKLMNOPQRSTUVWXYZ_1234567890";
	
	private static Map<Character, Integer> base64CharMap = new HashMap();
	
	static {
		assert base64Charset.length()==64;
		for( int i=0 ; i<base64Charset.length() ; i++ ){
			base64CharMap.put(base64Charset.charAt(i), i == 63 ? 0: (i+1));
		}
	}
	
	public static String getBase64(int base10) {
		StringBuilder builder = new StringBuilder();
		while (base10>0) {
			int remainder = (base10 % 64);
			remainder-=1;
			if(remainder==-1) remainder = 63;
			builder.insert(0, base64Charset.charAt(remainder));
			base10 = base10 / 64;
		}
		return builder.toString();
	}
	
//	public static int getBase10(String base64){
//		int val = 0;
//		for(int i=0; i<base64.length(); i++){
//			val = val + (int) ( (base64CharMap.get(base64.charAt(i)))* Math.pow(64, base64.length()-i-1));
//		}
//		return val;
//	}
	
	public static String convertToShortUrl(String longUrl) throws NoSuchAlgorithmException{
		
		 MessageDigest md = MessageDigest.getInstance("MD5");
		 md.update(longUrl.getBytes());
		 byte[] digest = md.digest();
		 String md5hash = DatatypeConverter
			      .printHexBinary(digest).toUpperCase();
		 
		 String secureShortenUrl = get_SHA_1_SecurePassword(md5hash);
		 
		 return secureShortenUrl.substring(0,8);
		
	}
	
	private static String get_SHA_1_SecurePassword(String passwordToHash)
    {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] bytes = md.digest(passwordToHash.getBytes());
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } 
        catch (NoSuchAlgorithmException e) 
        {
            e.printStackTrace();
        }
        return generatedPassword;
    }
}
