package com.example.demo.domain.todo.dto;

import com.example.demo.domain.todo.entity.Todo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static com.example.demo.domain.todo.dto.TodoDto.*;

@Mapper(componentModel = "spring")
public interface TodoMapper {

    @Mapping(target = "title", source = "createRequest.title")
    @Mapping(target = "description", source = "createRequest.description")
    @Mapping(target = "tags", source = "createRequest.tags")
    Todo toEntity(TodoDto.CreateRequest createRequest);

    @Mapping(target = "title", source = "title")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "tags", source = "tags")
    @Mapping(target = "createdAt", source = "createdAt")
    @Mapping(target = "updatedAt", source = "updatedAt")
    @Mapping(target = "todoId", source = "todoId")
    @Mapping(target = "isCompleted", source = "completed")
    CreateResponse toCreateTodoDto(Todo todo);

    @Mapping(target = "title", source = "title")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "tags", source = "tags")
    @Mapping(target = "createdAt", source = "createdAt")
    @Mapping(target = "updatedAt", source = "updatedAt")
    @Mapping(target = "todoId", source = "todoId")
    @Mapping(target = "isCompleted", source = "completed")
    GetTodo toGetTodoDto(Todo todo);

    @Mapping(target = "title", source = "title")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "tags", source = "tags")
    @Mapping(target = "createdAt", source = "createdAt")
    @Mapping(target = "updatedAt", source = "updatedAt")
    @Mapping(target = "todoId", source = "todoId")
    @Mapping(target = "isCompleted", source = "completed")
    UpdateResponse toUpdateTodoDto(Todo todo);

    @Mapping(target = "title", source = "title")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "tags", source = "tags")
    @Mapping(target = "createdAt", source = "createdAt")
    @Mapping(target = "updatedAt", source = "updatedAt")
    @Mapping(target = "todoId", source = "todoId")
    @Mapping(target = "isCompleted", source = "completed")
    CompleteTodo toCompleteTodoDto(Todo todo);

}