package com.niit.chat.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.niit.chat.config.ApplicationContextConfig;
import com.niit.chat.dao.UserInfoDao;
import com.niit.chat.model.UserInfo;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@Transactional
@ContextConfiguration(classes = { ApplicationContextConfig.class })
public class UserInfoDaoTestCase {
	final Logger log = LoggerFactory.getLogger(UserInfoDaoTestCase.class);
	@Autowired
	private UserInfoDao userInfoDao;
	@Autowired
	private UserInfo userInfo;

	@Test
	@Rollback(false)
	public void testAddUser() {

		userInfo.setUserName("Nikhil");
		userInfo.setUserEmail("nikhilarora684@gmail.com");
		userInfo.setPhone(3456789);
		userInfo.setPassword("12345");
		assertEquals("successfully added user", true, userInfoDao.addUser(userInfo));
	}

	@Test
	@Rollback(false)
	public void testUpdateUser() {
		userInfo = userInfoDao.getUserById(57);
		userInfo.setUserName("akhil");
		userInfo.setPassword("9811356113");
		userInfo.setPhone(6525);
		userInfo.setUserEmail("na8008983@gmail.com");
		assertEquals("successfully updated user", true, userInfoDao.updateUser(userInfo));
	}

	@Test

	public void testGetAllUser() {
		List<UserInfo> list = userInfoDao.getAllUser();
		assertEquals("reteriving data from table by id", true, list.size() > 0);
	}

	@Test

	public void testgetUserById() {
		try {
			List<UserInfo> list = userInfoDao.getAllUser();
			for (UserInfo u : list) {
				if (u.getUserName().equals("Nikhil") && u.getPassword().equals("12345")) {
					log.debug("user data is  found");
				}
			}
			userInfo = userInfoDao.getUserById(25);
			assertEquals("reteriving data from userinfo by id", true, userInfo.getUserName());
		} catch (AssertionError e) {
			e.printStackTrace();

		}
	}

	@Test
	@Rollback(false)
	public void testDeleteUser() {
		assertEquals("successfully deleted user", true, userInfoDao.deleteUser(userInfo));
	}

	@Test
	@Rollback(false)
	public void testgetUserByName() {
		assertEquals("user found", "na8008983@gmail.com", userInfoDao.getUserByName("Nikhil").getUserEmail());
		;

	}
}
