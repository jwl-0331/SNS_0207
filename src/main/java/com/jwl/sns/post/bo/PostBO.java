package com.jwl.sns.post.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jwl.sns.common.FileManagerService;
import com.jwl.sns.post.dao.PostDAO;
import com.jwl.sns.post.model.Post;
import com.jwl.sns.post.model.PostDetail;
import com.jwl.sns.user.bo.UserBO;
import com.jwl.sns.user.model.User;

@Service
public class PostBO {
	
	@Autowired
	private PostDAO postDAO;
	
	@Autowired
	private UserBO userBO;
	public int addPost(
			int userId
			, String content
			, MultipartFile file) {
		
		String imagePath = FileManagerService.saveFile(userId, file);
		return postDAO.insertPost(userId, content, imagePath);
	}
	
	public List<PostDetail> getPostList(int userId) {
		
		List<Post> postList = postDAO.selectPost(userId);
		
		// 생성된 postDetail 객체를 리스트로 구성한다
		List<PostDetail> postDetailList = new ArrayList<>();
		for(Post post:postList) {
			//postDetail 객체를 생성, post 객체의 정보를저장
			PostDetail postDetail = new PostDetail();
			postDetail.setId(post.getId());
			postDetail.setUserId(post.getUserId());
			postDetail.setContent(post.getContent());
			postDetail.setImagePath(post.getImagePath());
			
			User user = userBO.getUserById(post.getUserId());
			
			postDetail.setUserName(user.getName());
			//userName 값을 저장한다.
			//userDAO 호출 부자연 userBO 를 호출
			
			postDetailList.add(postDetail);
		}
		
		return postDetailList;
		
	}

}
