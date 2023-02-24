package com.example.demo.domain.chat.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ChatMessage {

    public enum MessageType {
        ENTER, TALK
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private MessageType type;
    //채팅방 ID
    private Long roomId;
    //보내는 사람
    private String sender;
    //내용
    private String message;
}
