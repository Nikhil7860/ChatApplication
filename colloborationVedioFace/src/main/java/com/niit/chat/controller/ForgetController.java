package com.niit.chat.controller;

import java.util.List;
import java.util.Random;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.chat.dao.UserInfoDao;
import com.niit.chat.emailservice.EmailService;
import com.niit.chat.model.UserInfo;

@Controller
public class ForgetController {
	@Autowired
	private UserInfo userInfo;
	@Autowired
	private UserInfoDao userInfoDao;
	@Autowired
	private EmailService emailService;

	static String myRandomNumber = "";
	static String userEmail = "";

	@RequestMapping(value = ("/forget"))
	public String forgetPage(Model model) {
		model.addAttribute("userInfo", new UserInfo());
		model.addAttribute("title", "forgetPage");
		return "forget";
	}

	@RequestMapping(value = ("/forgten"))
	public String otpPage(@ModelAttribute("userInfo") UserInfo userInfo, Model model) {
		List<UserInfo> users = userInfoDao.getAllUser();
		boolean isEmailValid = false;

		for (UserInfo user : users) {

			if (user.getUserEmail().equalsIgnoreCase(userInfo.getUserEmail())) {
				isEmailValid = true;
				userEmail = user.getUserEmail();
			}
		}

		if (isEmailValid) {
			String randomNumber = getRandomNumberString();
			myRandomNumber = randomNumber;
			System.out.println("My Random Nymber is : " + myRandomNumber);
			emailService.createdUserMessage(userInfo, "\n OTP to Reset Password " + randomNumber);

		} else {
			return "redirect:/forget";
		}
		return "verifyOtp";
	}

	@RequestMapping(value = ("/otpverify"))
	public String updatePasswordPage(Model model) {
		model.addAttribute("userInfo", userInfo);
		model.addAttribute("title", "Update Password");
		return "updatePassword";
	}

	@RequestMapping(value = ("/passwordUpdate"), method = RequestMethod.POST)
	public String otpVerifyPage(@ModelAttribute("userInfo") UserInfo userInfo, BindingResult result) {
		UserInfo user = userInfoDao.getUserEmail(userEmail);
		user.setPassword(userInfo.getPassword());
		user.setConfrimPassword(userInfo.getConfrimPassword());

		userInfoDao.updateUser(user);
		emailService.createdUserMessage(user, "\nYour password has been updated Successfully\n The Updated password is "
				+ user.getConfrimPassword());

		return "login";

	}

	private String getRandomNumberString() {
		// It will generate 6 digit random Number.
		// from 0 to 999999
		Random rnd = new Random();
		// This line is used to send 6 digit of OTP number
		int number = rnd.nextInt(999999);

		/*
		 * // This line is used to send 4 digit of OTP number int number =
		 * rnd.nextInt(9999);
		 */

		// this will convert any number sequence into 6 character.

		return String.format("%06d", number);

		/*
		 * // this will convert any number sequence into 4 character.
		 * 
		 * return String.format("%04d", number);
		 */
	}

}
