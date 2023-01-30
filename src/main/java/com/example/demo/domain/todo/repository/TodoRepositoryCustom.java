package com.example.demo.domain.todo.repository;

import com.example.demo.domain.todo.dto.TodoDto;
import com.example.demo.domain.todo.entity.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface TodoRepositoryCustom {
    Optional<Todo> findNotDeletedByTodoId(Integer todoId);

    Page<TodoDto.GetAllTodo> findAllTodosByCreatedDate(Pageable pageable);

    void deleteCommentByTodo(Integer todoId);

    List<TodoDto.GetAllTodo> findTodoByTItle(String title);
}
