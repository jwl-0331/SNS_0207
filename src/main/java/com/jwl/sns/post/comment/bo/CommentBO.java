package com.jwl.sns.post.comment.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwl.sns.post.comment.dao.CommentDAO;
import com.jwl.sns.post.comment.model.Comment;
import com.jwl.sns.post.comment.model.CommentDetail;
import com.jwl.sns.user.bo.UserBO;
import com.jwl.sns.user.model.User;

@Service
public class CommentBO {
	
	@Autowired
	private UserBO userBO;
	
	@Autowired
	private CommentDAO commentDAO;
	public int addComment(int userId, int postId, String content) {
		return commentDAO.insertComment(userId, postId, content);
	}
	
	//특정 post의 댓글 목록을 조회하는 기능
	public List<CommentDetail>getCommentList(int postId) {
		
		//댓글 조회 결과를 기반으로 댓글 마다 작성자 정보를 조회한다.
		List<Comment> commentList = commentDAO.selectCommentList(postId);
		
		List<CommentDetail> commentDetailList = new ArrayList<>();
		for(Comment comment: commentList) {
			CommentDetail commentDetail = new CommentDetail();
			
			commentDetail.setId(comment.getId());
			commentDetail.setPostId(comment.getPostId());
			commentDetail.setUserId(comment.getUserId());
			commentDetail.setContent(comment.getContent());
			
			User user = userBO.getUserById(comment.getUserId());
			
			commentDetail.setUserName(user.getName());
			
			commentDetailList.add(commentDetail);
		}
		
		return commentDetailList;
	}
}
