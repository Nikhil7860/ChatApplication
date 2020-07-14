package com.niit.chat.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.chat.dao.UserInfoDao;
import com.niit.chat.model.UserInfo;

public class Hello {
	public static void main(String[] args) {

		final Logger logger = LoggerFactory.getLogger(Hello.class);
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		logger.debug("Starting hello");
		context.scan("com.niit.chat");
		logger.debug("Starting hi");
		context.refresh();
		logger.debug("Starting bye");
		UserInfo userInfo = (UserInfo) context.getBean("userInfo");
		UserInfoDao userInfoDao = (UserInfoDao) context.getBean("userInfoDao");
		UserInfo nikhil = userInfoDao.getUserByName("nikhil");
		System.out.println(nikhil);

		logger.debug("Done.!!!");
		context.close();
	}
}
