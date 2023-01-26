package com.example.demo.domain.comment.service;

import com.example.demo.domain.comment.dto.CommentDto;
import com.example.demo.domain.comment.entity.Comment;

import java.util.List;

public interface CommentService {
    CommentDto.CreateResponse createComment(Integer todoId, CommentDto .CreateRequest createRequest);
    List<CommentDto.GetResponse> getCommentByTodoId(Integer todoId);
    Comment deleteComment(Integer todoId, Integer commnetId);
    CommentDto.GetResponse getComment(Integer todoId, Integer commentId);
    CommentDto.UpdateResponse updateComment(Integer todoId, Integer commentId,CommentDto.UpdateRequest updateRequest);
}
