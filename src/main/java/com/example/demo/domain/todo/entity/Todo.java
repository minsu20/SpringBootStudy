package com.example.demo.domain.todo.entity;


import javax.persistence.*;

import com.example.demo.domain.comment.entity.Comment;
import com.example.demo.global.entity.BaseTimeEntity;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Todo extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer todoId;

    private String title;

    private String description;

    private boolean isCompleted;

    private boolean isDeleted;

    @ElementCollection
    private List<String> tags=new ArrayList<>();

    @OneToMany(mappedBy="todo")
    private List<Comment>comments= new ArrayList<>();

    @Builder
    public Todo(String title, String description){
        this.title=title;
        this.description=description;
    }

}
