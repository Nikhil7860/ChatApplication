package com.niit.chat.controller;

import static java.lang.String.format;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;

import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import com.niit.chat.dao.UserInfoDao;
import com.niit.chat.model.ChatMessage;
import com.niit.chat.model.ChatMessage.MessageType;
import com.niit.chat.model.UserInfo;

@Controller
public class ChatController {
	@Autowired
	private UserInfo userInfo;
	@Autowired
	private UserInfoDao userInfoDao;
	@Autowired
	  private SimpMessageSendingOperations messagingTemplate;

	@RequestMapping(value = ("/chat"))
	public String chatPage(Model model) {
		model.addAttribute("userInfo", userInfo);
		model.addAttribute("title", "ChatBox");
		return "chatBox";
	}
	
	
	

	  @MessageMapping("/chat/{roomId}/sendMessage")
	  public void sendMessage(@DestinationVariable String roomId, @Payload ChatMessage chatMessage) {
	    messagingTemplate.convertAndSend(format("/channel/%s", roomId), chatMessage);
	  }

	  @MessageMapping("/chat/{roomId}/addUser")
	  public void addUser(@DestinationVariable String roomId, @Payload ChatMessage chatMessage,
	      SimpMessageHeaderAccessor headerAccessor) {
	    String currentRoomId = (String) headerAccessor.getSessionAttributes().put("room_id", roomId);
	    if (currentRoomId != null) {
	    ChatMessage leaveMessage = new ChatMessage();
	    
	    leaveMessage.setType(MessageType.LEAVE);
	    leaveMessage.setSender(chatMessage.getSender());
	      messagingTemplate.convertAndSend(format("/channel/%s", currentRoomId), leaveMessage);
	    }
	    headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
	    messagingTemplate.convertAndSend(format("/channel/%s", roomId), chatMessage);
	  }


}
