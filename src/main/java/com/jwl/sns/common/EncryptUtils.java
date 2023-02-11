package com.jwl.sns.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptUtils {
	
	//암호화 진행 암호화된 문자열로 반환
	//암호화 할 문자열을 받는다 - messaage
	public static String md5(String message) {
		
		//16진수 문자열 암호화 저장할 변수
		String resultData = "";
		// md5 암호화 객체 생성
		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			
			//message 를 바이트 type으로 변환
			byte[] bytes = message.getBytes();
			
			//md객체에 업데이트
			md.update(bytes);
			
			//암호화 진행
			byte[] digest = md.digest();
			
			for(int i = 0 ; i < digest.length;i++) {
				resultData += Integer.toHexString(digest[i] & 0xff);
			}
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultData;
	}
}
