package com.example.demo.domain.chat.controller;

import com.example.demo.domain.chat.entity.ChatMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

import static com.example.demo.domain.chat.constant.ChatMessageConstants.EChatMessageServiceImpl.eChatRoomEnterMessage;
import static com.example.demo.domain.chat.constant.ChatMessageConstants.EChatMessageServiceImpl.eChatRoomOutMessage;

@RestController
@RequiredArgsConstructor
public class ChatMessageController {
    private final SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/chatRoom/enter")
    public void enterChatRoom(ChatMessage message) {
        String enterMessage=message.getSender()+eChatRoomEnterMessage.getValue();
        simpMessagingTemplate.convertAndSend("/sub/chatRoom/"+message.getRoomId(),enterMessage);
    }

    @MessageMapping("/chatRoom/send")
    public void sendChatMessage(ChatMessage message) {
        simpMessagingTemplate.convertAndSend("/sub/chatRoom/"+message.getRoomId(),message);
    }

    @MessageMapping("/chatRoom/out")
    public void outChatRoom(ChatMessage message) {
        String outMessage=message.getSender()+eChatRoomOutMessage.getValue();
        simpMessagingTemplate.convertAndSend("/sub/chatRoom/"+message.getRoomId(),outMessage);
    }

}
