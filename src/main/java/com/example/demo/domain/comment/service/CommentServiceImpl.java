package com.example.demo.domain.comment.service;

import com.example.demo.domain.comment.dto.CommentDto;
import com.example.demo.domain.comment.dto.CommentMapper;
import com.example.demo.domain.comment.entity.Comment;
import com.example.demo.domain.comment.exception.NotFoundCommentException;
import com.example.demo.domain.comment.repository.CommentRepository;
import com.example.demo.domain.todo.entity.Todo;
import com.example.demo.domain.todo.exception.NotFoundTodoException;
import com.example.demo.domain.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{

    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;
    private final TodoRepository todoRepository;


    @Override
    public CommentDto.CreateResponse createComment(Integer todoId, CommentDto.CreateRequest createRequest){
        Todo todo=this.validateTodoById(todoId);
        Comment comment=this.commentMapper.toEntity(createRequest);
        comment.setTodo(todo);
        return this.commentMapper.toCreateDto(this.commentRepository.save(comment));
    }

    @Override
    public List<CommentDto.GetResponse> getCommentByTodoId(Integer todoId){
        this.validateTodoById(todoId);
        return this.commentRepository.getCommentByTodoId(todoId);
    }

    @Override
    public Comment deleteComment(Integer todoId,Integer commentId){
        this.validateTodoById(todoId);
        Comment comment=this.validateCommentById(commentId);
        comment.setDeleted(true);
        return this.commentRepository.save(comment);
    }

    @Override
    public CommentDto.GetResponse getComment(Integer todoId, Integer commentId){
        this.validateTodoById(todoId);
        Comment comment=this.validateCommentById(commentId);
        return this.commentMapper.toGetDto(comment);
    }

    @Override
    public CommentDto.UpdateResponse updateComment(Integer todoId, Integer commentId, CommentDto.UpdateRequest updateRequest){
        this.validateTodoById(todoId);
        Comment comment=this.validateCommentById(commentId);
        comment.setContent(updateRequest.getContent());
        comment.setUpdatedAt(LocalDateTime.now());
        return this.commentMapper.toUpdateDto(comment);
    }

    private Todo validateTodoById(Integer todoId){
        return this.todoRepository.findNotDeletedByTodoId(todoId).orElseThrow(NotFoundTodoException::new);
    }

    private Comment validateCommentById(Integer commentId){
        return this.commentRepository.findNotDeletedByCommentId(commentId).orElseThrow(NotFoundCommentException::new);
    }

}
