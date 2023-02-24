package com.example.demo.domain.user.entity;

import com.example.demo.domain.chat.entity.ChatRoom;
import com.example.demo.domain.user.constant.UserConstants;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    private String email;

    private String password;


    @Enumerated(EnumType.STRING)
    private UserConstants.Role role;

    public void encryptPassword(PasswordEncoder passwordEncoder) {
        password = passwordEncoder.encode(password);
    }

}
