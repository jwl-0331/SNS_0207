package com.jwl.sns.post.like.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwl.sns.post.like.dao.LikeDAO;



@Service
public class LikeBO {
	
	
	@Autowired
	private LikeDAO likeDAO;	
	public int addLike(int userId, int postId) {
		
		return likeDAO.insertLike(userId, postId);
	}
	
	public int deleteLike(int userId, int postId) {
		return likeDAO.deleteLike(userId, postId);
	}
	//게시글별 좋아요 개수 얻기 기능
	public int getLikeCount(int postId) {
		return likeDAO.selectCountLike(postId);
	}
}
