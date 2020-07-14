package com.niit.chat.dao;

import java.util.List;

import com.niit.chat.model.UserInfo;

public interface UserInfoDao {
	boolean addUser(UserInfo user);

	public boolean deleteUser(UserInfo userInfo);

	boolean updateUser(UserInfo user);

	public UserInfo getUserById(int userId);

	public List<UserInfo> getAllUser();

	public UserInfo getUserEmail(String emailId);

	public UserInfo getUserByName(String userName);
}
