package com.example.demo.domain.chat.service;

import com.example.demo.domain.chat.entity.ChatRoom;

import java.util.List;

public interface ChatService {
    List<ChatRoom> getAllChatRoom();
    ChatRoom getById(Long roomId);
    ChatRoom createRoom(String name);
}
