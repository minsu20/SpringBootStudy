package com.example.demo.domain.chat.service;

import com.example.demo.domain.chat.entity.ChatRoom;
import com.example.demo.domain.chat.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

@RequiredArgsConstructor
@Service
@Slf4j
public class ChaServiceImpl implements ChatService{
    private final ChatRoomRepository chatRoomRepository;

    //채팅방 불러오기
    @Override
    public List<ChatRoom> getAllChatRoom() {
        return chatRoomRepository.findAll();
    }


    //채팅방 하나 불러오기
    @Override
    public ChatRoom getById(Long roomId) {
        return chatRoomRepository.findById(roomId).orElseThrow();
    }

    //채팅방 생성
    @Override
    public ChatRoom createRoom(String name) {
        ChatRoom chatRoom = new ChatRoom();
        chatRoom.setRoomName(name);
        return chatRoomRepository.save(chatRoom);
    }
}
