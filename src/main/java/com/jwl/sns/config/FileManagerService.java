package com.jwl.sns.config;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileManagerService {
	public static final String fileUploadPath = "C:\\Users\\mm940\\Documents\\lecture\\webProjectSNS\\images";
	
	//클래스 정보를 인자로 전달
	private static Logger logger = LoggerFactory.getLogger(FileManagerService.class);
			
	public static String saveFile(int userId, MultipartFile file) {
		//파일 저장		
		//사용자 별로 폴더를 구분한다.
		//사용자 별로 폴더를 새로 만든다.
		//폴더 이름 : userId_현재시간
		//UNIX TIME : 1970년 1월 1일부터 흐른 시간 (millisecond 1/1000)
		//C:\Users\mm940\Documents\lecture\webProjectMemo\images\\2_142485124\\asdf.png
				
		String directoryName = "/" + userId + "_" + System.currentTimeMillis() + "/";
				
		//디렉토리 생성
		String directoryPath = fileUploadPath + directoryName;
				
		//파일 객체 생성
		File directory = new File(directoryPath);
				
		if(directory.mkdir() == false) {
			//디렉토리 생성 실패
			//디렉토리 생성 실패 로그 추가
			logger.error("savefile : 디렉토리 생성 실패");
			return null;
		}
				
		//파일 다루기 까다롭다 문제 생길 가능성을 관리를 해주어야한다
				
		//파일 저장
		try {
			byte[] bytes = file.getBytes();
					
			String filePath = directoryPath + file.getOriginalFilename();
			Path path = Paths.get(filePath);
			Files.write(path, bytes);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
					
			return null;
		}
				
		//클라이언트에 접근 가능한 경로를 문자열로 리턴
				
		//규칙 정해주기 http://localhost:8090/images/~
		// /images/2_38239823/test.png
		return "/images" + directoryName + file.getOriginalFilename();
	}
}
