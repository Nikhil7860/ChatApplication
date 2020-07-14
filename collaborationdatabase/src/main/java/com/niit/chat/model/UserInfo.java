package com.niit.chat.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToOne;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

import com.niit.chat.model.ChatMessage.MessageType;

@Component
@Entity

public class UserInfo extends Error {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	@NotEmpty(message = "User Name cannot be Empty")
	// @Size(min = 12, max = 7, message = "Name should contain atleast 5 characters")
	private String userName;
	@NotEmpty(message = "User Email cannot be empty")
	@Email(message = "Enter a valid Email")
	@Pattern(regexp = ".+@.+\\..+", message = "Worng Email Entered")
	private String userEmail;
	@NotEmpty(message = "Password  cannot be empty")
	// @Size(min=5,max=15,message="Password cannot be more than 15 characters")
	private String password;
	@NotEmpty(message = "Confrim Password  cannot be empty")
	private String confrimPassword;
 //@Pattern(regexp="\\d{10}$",message="Enter 10 Digit Number")
	private long phone;
	private int isActive = 1;
	private int otp;
	@OneToOne(targetEntity = Authorization.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "roleId", referencedColumnName = "userId")
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfrimPassword() {
		return confrimPassword;
	}
	public void setConfrimPassword(String confrimPassword) {
		this.confrimPassword = confrimPassword;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public int getIsActive() {
		return isActive;
	}
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}
	public int getOtp() {
		return otp;
	}
	public void setOtp(int otp) {
		this.otp = otp;
	}
	
	
	

	

	
}