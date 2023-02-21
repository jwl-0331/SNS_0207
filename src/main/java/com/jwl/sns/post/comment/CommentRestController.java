package com.jwl.sns.post.comment;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jwl.sns.post.comment.bo.CommentBO;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/post/comment")
public class CommentRestController {
	
	
	@Autowired
	private CommentBO commentBO;
	@PostMapping("/create")
	public Map<String, String> createComment(
			@RequestParam("postId")int postId
			,@RequestParam("content")String content
			,HttpSession session) {
		
		int userId = (int)session.getAttribute("userId");
		int count = commentBO.addComment(userId, postId, content);
	
		Map<String, String> result = new HashMap<>();
		if(count == 1){
			result.put("result","success");
		}else {
			result.put("result", "fail");
		}
		
		return result;
	}
}
