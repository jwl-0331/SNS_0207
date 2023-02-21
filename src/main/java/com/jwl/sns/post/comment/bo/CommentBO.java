package com.jwl.sns.post.comment.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwl.sns.post.comment.dao.CommentDAO;

@Service
public class CommentBO {
	
	
	@Autowired
	private CommentDAO commentDAO;
	public int addComment(int userId, int postId, String content) {
		return commentDAO.insertComment(userId, postId, content);
	}
}
