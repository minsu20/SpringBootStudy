package com.example.demo.domain.comment.dto;

import com.example.demo.domain.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CommentMapperSupport {

    private final TodoService todoService;

}
