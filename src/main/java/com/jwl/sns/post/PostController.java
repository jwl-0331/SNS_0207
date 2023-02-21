package com.jwl.sns.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jwl.sns.post.bo.PostBO;
import com.jwl.sns.post.model.PostDetail;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	private PostBO postBO;
	@GetMapping("/timeline/view")
	public String timelineView(Model model
			, HttpSession session ) {
		int userId = (int)session.getAttribute("userId");
		List<PostDetail> postDetailList = postBO.getPostList(userId);
		
		model.addAttribute("postList",postDetailList);
		
		return "post/timeline";
	}
}
