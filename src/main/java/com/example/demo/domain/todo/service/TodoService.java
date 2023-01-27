package com.example.demo.domain.todo.service;

import com.example.demo.global.dto.PaginationDto;
import com.example.demo.domain.todo.dto.TodoDto;
import com.example.demo.domain.todo.entity.Todo;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TodoService {

    TodoDto.CreateResponse createTodo(TodoDto.CreateRequest createRequest);
    TodoDto.GetTodo getById(Integer todoId);
    TodoDto.UpdateResponse updateById(Integer todoId, TodoDto.UpdateRequest updateRequest);
    TodoDto.CompleteTodo completeById(Integer todoId);
    Todo deleteTodo(Integer todoId);
    PaginationDto<List<TodoDto.GetAllTodo>> getAll(Pageable page);
    List<TodoDto.GetAllTodo> findByTitle(String title);
}
