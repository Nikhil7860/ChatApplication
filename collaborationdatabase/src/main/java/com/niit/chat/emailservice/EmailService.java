package com.niit.chat.emailservice;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.niit.chat.model.UserInfo;

@Service(value = "emailService")
public class EmailService {
	@Autowired
	private JavaMailSender mailSender;
	private static String from = "ChatApp";

	public void createdUserMessage(UserInfo userInfo, String message) {
		MimeMessage mime = mailSender.createMimeMessage();
		MimeMessageHelper helper = null;

		// apply loop here to send email to multiple people
		try {
			helper = new MimeMessageHelper(mime, false, "utf-8");
			StringBuilder msg = new StringBuilder();
			msg.append("<h1>Welcome " + userInfo.getUserName() + " " + userInfo.getUserEmail() + " on ChatApp !</h1>");
			msg.append("<p>" + message + "</p><br/>");
			msg.append("<p>Thanks for joining with us!</p><br/>");

			// add the HTML content to the mimeMessage
			mime.setContent(msg.toString(), "text/html");

			helper.setTo(userInfo.getUserEmail());
			helper.setSubject("WELCOME TO ChatApp");
			helper.setFrom(from);

			// send the message
			mailSender.send(mime);

		} catch (MessagingException e) {
			e.printStackTrace();

		}
	}
}
