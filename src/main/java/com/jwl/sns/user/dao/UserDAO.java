package com.jwl.sns.user.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO {
	public int insertUser(
			@Param("loginId")String loginId
			,@Param("password") String password
			,@Param("name") String name
			,@Param("email") String email);
}
