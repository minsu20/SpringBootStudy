package com.example.demo.domain.chat.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ChatMessageConstants {
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public enum EChatMessageServiceImpl {
        eChatRoomEnterMessage("님이 채팅방에 들어왔습니다."),
        eChatRoomOutMessage("님이 채팅방에 나갔습니다.");
        private String value;
    }
}
