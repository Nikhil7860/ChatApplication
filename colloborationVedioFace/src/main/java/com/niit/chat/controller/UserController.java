package com.niit.chat.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.chat.dao.UserInfoDao;
import com.niit.chat.emailservice.EmailService;
import com.niit.chat.model.UserInfo;

@Controller
public class UserController {
	@Autowired
	private EmailService emailService;
	@Autowired
	private UserInfoDao userInfoDao;
	static String userEmail = "";
	boolean isEmailValid = false;

	@RequestMapping(value = ("/Sucess"), method = RequestMethod.POST)
	public String addUser(@Valid @ModelAttribute("userInfo") UserInfo userInfo, BindingResult result) {

		List<UserInfo> users = userInfoDao.getAllUser();

		for (UserInfo user : users) {

			if (userInfo.getUserEmail().equals(user.getUserEmail())) {
				isEmailValid = true;
				userEmail = user.getUserEmail();
				
			}
			
		}
		/*if (result.hasErrors()) {
			return "register";

		}*/

		if (isEmailValid) {
		
			System.out.println("Email id already exist in the database" );
			return "register";
		}
		userInfoDao.addUser(userInfo);
		emailService.createdUserMessage(userInfo, "Greetings");
		return "redirect:/login";

		
	}

	@RequestMapping(value = ("/edit"), method = RequestMethod.POST)
	public String updateUser(@Valid @ModelAttribute("userInfo") UserInfo userInfo, BindingResult result) {
		/*
		 * if(result.hasErrors()) { return "profile";
		 * 
		 * }
		 */
		userInfoDao.updateUser(userInfo);
		return "userPage";

	}

	@RequestMapping(value = ("/del"), method = RequestMethod.GET)
	public String deleteUser(@Valid @ModelAttribute("userInfo") UserInfo userInfo, BindingResult result) {
		/*
		 * if(result.hasErrors()) { return "delete"; }
		 */

		userInfoDao.deleteUser(userInfo);
		return "userPage";

	}

	/*
	 * @RequestMapping(value=("/srch"),method=RequestMethod.POST) public String
	 * getUserById(@Valid @ModelAttribute("userInfo") UserInfo
	 * userInfo,BindingResult result) { if(result.hasErrors()) { return "error";
	 * 
	 * } userInfoDao.getUserByName("userName"); return "searchList"; }
	 * 
	 * 
	 */

}
