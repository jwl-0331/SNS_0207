package com.jwl.sns.user.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.jwl.sns.user.model.User;

@Repository
public interface UserDAO {
	public int insertUser(
			@Param("loginId")String loginId
			,@Param("password") String password
			,@Param("name") String name
			,@Param("email") String email);
	
	public int selectUserById(@Param("loginId")String loginId);
	
	public User selectUser(
			@Param("loginId")String loginId
			,@Param("password")String password);
	
	public User selectUserByIdp(@Param("id")int id);
}
