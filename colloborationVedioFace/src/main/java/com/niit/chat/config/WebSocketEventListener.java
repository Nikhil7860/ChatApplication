package com.niit.chat.config;

import static java.lang.String.format;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import com.niit.chat.model.ChatMessage;
import com.niit.chat.model.ChatMessage.MessageType;



@Component
public class WebSocketEventListener {
	 @Autowired
	  private SimpMessageSendingOperations messagingTemplate;
	 
	 @EventListener
	  public void handleWebSocketConnectListener(SessionConnectedEvent event) {
	   
	  }
	 
	 @EventListener
	  public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
	    StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());

	    String username = (String) headerAccessor.getSessionAttributes().get("username");
	    String roomId = (String) headerAccessor.getSessionAttributes().get("room_id");
	    if (username != null) {
	   

	      ChatMessage chatMessage = new ChatMessage();
	      chatMessage.setType(MessageType.LEAVE);
	      chatMessage.setSender(username);

	      messagingTemplate.convertAndSend(format("/channel/%s", roomId), chatMessage);
	    }
	  }
}
