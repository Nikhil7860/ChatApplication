package com.niit.chat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.chat.dao.UserInfoDao;
import com.niit.chat.model.UserInfo;

@Controller
public class AdminController 
{
	@Autowired
	private UserInfo userInfo;
	@Autowired
	private UserInfoDao userInfoDao;

	@RequestMapping("/admin/Home")
	public String adminPage(Model model) {

		model.addAttribute("title", "Admin");
		return "admin";
	}

	@RequestMapping("/UserList")
	public String adminUserList(Model model) {
		model.addAttribute("userList", userInfoDao.getAllUser());
		model.addAttribute("title", "AdminUserList");
		return "userList";
	}

	@RequestMapping(value = "/update/{userId}")
	public String profilePage(@PathVariable("userId") int userId, Model model) {

		UserInfo userInfo = userInfoDao.getUserById(userId);
		model.addAttribute("title", "Profile Page");
		model.addAttribute("userInfo", userInfo);
		return "profile";
	}

	@RequestMapping(value = "/Delete/{userId}")
	public String deletePage(@PathVariable("userId") int userId, Model model) {

		UserInfo userInfo = userInfoDao.getUserById(userId);
		model.addAttribute("title", "Delete Account Permanently");
		model.addAttribute("userInfo", userInfo);
		return "delete";
	}
}
