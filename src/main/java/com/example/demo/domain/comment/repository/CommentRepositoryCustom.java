package com.example.demo.domain.comment.repository;

import com.example.demo.domain.comment.dto.CommentDto;
import com.example.demo.domain.comment.entity.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentRepositoryCustom {
    Optional<Comment> findNotDeletedByCommentId(Integer commentId);

    List<CommentDto.GetResponse> getCommentByTodoId(Integer todoId);

}
