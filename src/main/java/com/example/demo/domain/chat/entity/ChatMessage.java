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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //채팅방 ID
    private Integer roomId;
    //보내는 사람
    private String sender;
    //내용
    private String message;
}
