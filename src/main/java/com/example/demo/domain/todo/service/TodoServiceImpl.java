package com.example.demo.domain.todo.service;

import com.example.demo.domain.comment.repository.CommentRepository;
import com.example.demo.domain.todo.dto.TodoMapper;
import com.example.demo.global.dto.PaginationDto;
import com.example.demo.domain.todo.dto.TodoDto;
import com.example.demo.domain.todo.entity.Todo;
import com.example.demo.domain.todo.exception.NotFoundTodoException;
import com.example.demo.domain.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService{
    private final TodoRepository todoRepository;
    private final TodoMapper todoMapper;
    private final CommentRepository commentRepository;

    @Override
    public TodoDto.CreateResponse createTodo(TodoDto.CreateRequest createRequest){
        Todo todo=this.todoMapper.toEntity(createRequest);
        return this.todoMapper.toCreateTodoDto(this.todoRepository.save(todo));
    }

    @Override
    public TodoDto.GetTodo getById(Integer todoId){
        Todo todo=this.validateById(todoId);
        return this.todoMapper.toGetTodoDto(todo);
    }

    @Override
    public TodoDto.UpdateResponse updateById(Integer todoId, TodoDto.UpdateRequest updateRequest){
        Todo todo=this.validateById(todoId);
        if(updateRequest.getDescription()!=null){
            todo.setDescription(updateRequest.getDescription());
        }
        if(updateRequest.getTags()!=null){
            todo.setTags(updateRequest.getTags());
        }
        if(updateRequest.getTitle()!=null){
            todo.setTitle(updateRequest.getTitle());
        }
        this.todoRepository.save(todo);
        return this.todoMapper.toUpdateTodoDto(this.validateById(todoId));
    }

    @Override
    public TodoDto.CompleteTodo completeById(Integer todoId){
        Todo todo=this.validateById(todoId);
        todo.setCompleted(true);
        return this.todoMapper.toCompleteTodoDto(this.todoRepository.save(todo));
    }

    @Override
    public Todo deleteTodo(Integer todoId){
        Todo todo=this.validateById(todoId);
        todo.setDeleted(true);
        this.todoRepository.deleteCommentByTodo(todoId);
        return this.todoRepository.save(todo);
    }

    @Override
    public PaginationDto<List<TodoDto.GetAllTodo>> getAll(Pageable pageable){
        Page<TodoDto.GetAllTodo> page=this.todoRepository.findAllTodosByCreatedDate(pageable);
        List<TodoDto.GetAllTodo> data=page.get().collect(Collectors.toList());
        return PaginationDto.of(page,data);
    }

    @Override
    public List<TodoDto.GetAllTodo> findByTitle(String title){
        List<TodoDto.GetAllTodo> search=this.todoRepository.findTodoByTItle(title);
        return search;
    }

    private Todo validateById(Integer todoId){
        return this.todoRepository.findNotDeletedByTodoId(todoId).orElseThrow(NotFoundTodoException::new);
    }
}
