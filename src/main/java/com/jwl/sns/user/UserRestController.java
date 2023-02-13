package com.jwl.sns.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jwl.sns.user.bo.UserBO;
import com.jwl.sns.user.model.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserRestController {
	
	@Autowired
	private UserBO userBO;
	@PostMapping("/signup")
	public Map<String, String>signup(
			@RequestParam("loginId")String loginId
			,@RequestParam("password") String password
			,@RequestParam("name") String name
			,@RequestParam("email") String email) {
		int count = userBO.addUser(loginId, password, name, email);
		
		Map<String, String> map = new HashMap<>();
		if(count == 1) {
			map.put("result", "success");
		}else {
			map.put("result", "fail");
		}
		
		return map;
	}
	
	@GetMapping("/duplicate_id")
	public Map<String, Boolean> isDuplicate(@RequestParam("loginId")String loginId){
		
		Map<String,Boolean> map = new HashMap<>();
		map.put("is_duplicate", userBO.isDuplicateId(loginId));
		return map;
	}
	
	@PostMapping("/signin")
	public Map<String, String> signin(
			@RequestParam("loginId")String loginId
			,@RequestParam("password") String password
			, HttpServletRequest request){
		User user = userBO.getUser(loginId, password);
		
		Map<String, String> map = new HashMap<>();
		if(user != null){
			map.put("result", "success");
			//모든 페이지에서 공용으로 사용할 수 있는 데이터가 생겼다 - 세션
			//세션에 저장하기 위해 request 추가
			//세션 객체 얻어오기
			HttpSession session = request.getSession();
			
			//세션에 특정한 값이 저장되있으면 로그인 된 상태
			//세션에 특정한 값이 저장 되있지 않으면 로그인이 안된 상태
			session.setAttribute("userId", user.getId()); //1,2, id coloumn 저장
			session.setAttribute("userName", user.getName());
		}else {
			map.put("result", "fail");
		}
		
		return map;
	}
}
