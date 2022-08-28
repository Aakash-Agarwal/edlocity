package com.edlocity.springboot_stomp_chatapplication.configurations.models;

import lombok.Data;

@Data
public class ChatMessage {

    private String content;
    private String sender;
    private MessageType messageType;

    private enum MessageType {
        CHAT, JOIN, LEAVE
    }
}
