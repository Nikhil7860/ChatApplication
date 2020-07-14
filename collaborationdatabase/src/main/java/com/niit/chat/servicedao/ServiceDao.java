package com.niit.chat.servicedao;

import java.util.List;

import com.niit.chat.model.UserInfo;

public interface ServiceDao {
	boolean addUser(UserInfo user);

	boolean deleteUser(UserInfo userInfo);

	boolean updateUser(UserInfo user);

	UserInfo getUserById(int userId);

	List<UserInfo> getAllUser();

	UserInfo getUserEmail(String emailId);

}
