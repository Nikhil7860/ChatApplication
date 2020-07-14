package com.niit.chat.controller;

import java.security.Principal;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.chat.dao.UserInfoDao;
import com.niit.chat.emailservice.EmailService;
import com.niit.chat.model.UserInfo;

@Controller
public class HomeController {
	@Autowired
	private UserInfo userInfo;
	@Autowired
	private UserInfoDao userInfoDao;
	@Autowired
	private EmailService emailService;

	@RequestMapping(value = { "/", "/index" })
	public String homePage(Model model) {
		model.addAttribute("title", "ChatApp");
		return "index";
	}

	@RequestMapping(value = ("/login"))
	public String loginPage(Model model) {
		model.addAttribute("title", "Login");
		return "login";
	}

	@RequestMapping(value = ("/register"))
	public String registerPage(Model model) {

		model.addAttribute("title", "Registration");
		model.addAttribute("userInfo", userInfo);

		return "register";

	}

	/*@RequestMapping(value = "/tik")
	public String displayPage(Principal p, Model model) {
		String emailId = p.getName();
		UserInfo userInfo = userInfoDao.getUserEmail(emailId);
		model.addAttribute("userInfo", userInfo);
		return "profile";
	}*/

	@RequestMapping(value = "/tok")
	public String deleteUser(Principal p, Model model) {
		String emailId = p.getName();
		UserInfo userInfo = userInfoDao.getUserEmail(emailId);
		model.addAttribute("userInfo", userInfo);
		return "delete";
	}

	@RequestMapping("/user/Home")
	public String userPage(Principal p,Model model) {

		model.addAttribute("title", "Home");
		String emailId = p.getName();
		UserInfo userInfo = userInfoDao.getUserEmail(emailId);
		model.addAttribute("userInfo", userInfo);
		return "userPage";
	}

	@RequestMapping("/logout")
	public String logoutPage(Model model) {
		model.addAttribute("msg", "Logout successfully");
		return "login";
	}

	/*
	 * @RequestMapping(value=("/vedio")) public String vedioPage(Model model) {
	 * model.addAttribute("userInfo", userInfo); model.addAttribute("title",
	 * "VedioBox"); return "vedio"; }
	 */

	@RequestMapping(value = "/editUser")
	public String editUser(Model model) {
		return "editUser";
	}

	@RequestMapping("/srch")
	public String searchList(Model model) {
		model.addAttribute("userList", userInfoDao.getAllUser());
		model.addAttribute("title", "UserList");
		return "searchList";
	}
	/*
	 * @RequestMapping(value="/Delete") public String deletePage(Principal
	 * p,Model model) { String emailId=p.getName(); UserInfo
	 * userInfo=userInfoDao.getUserEmail(emailId); model.addAttribute("title",
	 * "Delete Account Permanently"); model.addAttribute("userInfo",userInfo);
	 * return "delete"; }
	 */

}
