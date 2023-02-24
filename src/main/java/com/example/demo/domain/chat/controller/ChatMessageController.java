package com.example.demo.domain.chat.controller;

import com.example.demo.domain.chat.entity.ChatMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ChatMessageController {
    private final SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/chatRoom/message")
    public void enterChatRoom(ChatMessage message) {
        simpMessagingTemplate.convertAndSend("/sub/chatRoom/"+message.getRoomId(),message);
    }
}
