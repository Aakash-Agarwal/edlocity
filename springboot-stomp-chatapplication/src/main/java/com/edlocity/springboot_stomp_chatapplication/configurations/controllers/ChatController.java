package com.edlocity.springboot_stomp_chatapplication.configurations.controllers;

import com.edlocity.springboot_stomp_chatapplication.configurations.models.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @MessageMapping("/chat.register")
    @SendTo("/listen/chat")
    public ChatMessage addUser(@Payload ChatMessage message, SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("username", message.getSender());
        return message;
    }

    @MessageMapping("/chat.talk")
    @SendTo("/listen/chat")
    public ChatMessage chat(@Payload ChatMessage message) {
        return message;
    }
}
