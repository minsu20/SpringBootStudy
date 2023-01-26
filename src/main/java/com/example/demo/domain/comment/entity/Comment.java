package com.example.demo.domain.comment.entity;

import com.example.demo.domain.todo.entity.Todo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentId;

    private String content;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private boolean isDeleted;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="todo_id")
    private Todo todo;

    /**
     * 연관관계 매핑
     */

    public void setTodo(Todo todo){
        this.todo=todo;
        todo.getComments().add(this);
    }
}
