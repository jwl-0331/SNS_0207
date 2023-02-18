package com.jwl.sns.post.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jwl.sns.config.FileManagerService;
import com.jwl.sns.post.dao.PostDAO;
import com.jwl.sns.post.model.Post;

@Service
public class PostBO {
	
	@Autowired
	private PostDAO postDAO;
	public int addPost(
			int userId
			, String content
			, MultipartFile file) {
		
		String imagePath = FileManagerService.saveFile(userId, file);
		return postDAO.insertPost(userId, content, imagePath);
	}
	
	public List<Post> getPostList(int userId) {
		
		return postDAO.selectPost(userId);
	}

}
