package com.jwl.sns.post.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.jwl.sns.post.model.Post;

@Repository
public interface PostDAO {
	public int insertPost(
			@Param("userId") int userId
			, @Param("content") String content
			, @Param("imagePath") String imagePath);
	
	public List<Post> selectPost(@Param("userId") int userId);
}
