package com.jwl.sns.user.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwl.sns.common.EncryptUtils;
import com.jwl.sns.user.dao.UserDAO;
import com.jwl.sns.user.model.User;

@Service
public class UserBO {
	
	@Autowired
	private UserDAO userDAO;
	public int addUser(String loginId
			, String password
			, String name
			, String email) {
		
		String encryptPassword = EncryptUtils.md5(password);
		
		return userDAO.insertUser(loginId, encryptPassword, name, email);
	}
	
	public boolean isDuplicateId(String loginId) {
		int count = userDAO.selectUserById(loginId);
		
		if(count == 0) {
			return false;
		}else {
			return true;
		}
	}
	
	public User getUser(String loginId, String password) {
		
		String encryptPassword = EncryptUtils.md5(password);
		return userDAO.selectUser(loginId, encryptPassword);
	}
}
