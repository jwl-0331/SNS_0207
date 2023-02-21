package com.jwl.sns.post.like;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jwl.sns.post.like.bo.LikeBO;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/post")
public class LikeRestController {
	
	@Autowired
	private LikeBO likeBO;
	@GetMapping("/like")
	public Map<String, String> like(
			@RequestParam("postId") int postId
			, HttpSession session){
		int userId = (int)session.getAttribute("userId");
		int count = likeBO.addLike(userId, postId);
		
		Map<String, String> result = new HashMap<>();
		if(count == 1) {
			result.put("result", "success");
		}else{
			result.put("result", "fail");
		}
		
		return result;
	}
	
	@GetMapping("/unlike")
	public Map<String, String> unlike(
			@RequestParam("postId") int PostId
			, HttpSession session){
		int userId = (int)session.getAttribute("userId");
		int count = likeBO.deleteLike(userId, PostId);
		Map<String, String> result = new HashMap<>();
		if(count == 1) {
			result.put("result", "success");
		}else {
			result.put("result", "fail");
		}
		
		return result;
	}
	
}
