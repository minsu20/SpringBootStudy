package com.example.demo.domain.todo.entity;


import javax.persistence.*;

import com.example.demo.domain.comment.entity.Comment;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Todo{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer todoId;

    private String title;

    private String description;

    private boolean isCompleted;

    private boolean isDeleted;

    private LocalDateTime createdAt;

    @ElementCollection
    private List<String> tags=new ArrayList<>();

    private LocalDateTime updatedAt;

    @OneToMany(mappedBy="todo")
    private List<Comment>comments= new ArrayList<>();

    @Builder
    public Todo(String title, String description){
        this.title=title;
        this.description=description;
    }

}
