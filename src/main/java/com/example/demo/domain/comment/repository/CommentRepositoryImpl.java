package com.example.demo.domain.comment.repository;

import com.example.demo.domain.comment.dto.CommentDto;
import com.example.demo.domain.comment.dto.QCommentDto_GetResponse;
import com.example.demo.domain.comment.entity.Comment;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

import static com.example.demo.domain.comment.entity.QComment.comment;

public class CommentRepositoryImpl implements CommentRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    public CommentRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<CommentDto.GetResponse> getCommentByTodoId(Integer todoId) {
        return queryFactory.select(new QCommentDto_GetResponse(comment.commentId, comment.content, comment.createdAt, comment.updatedAt)).from(comment)
                .where(comment.todo.todoId.eq(todoId)).fetch();
    }

    @Override
    public Optional<Comment> findNotDeletedByCommentId(Integer commentId) {
        return Optional.ofNullable(queryFactory.selectFrom(comment)
                .where(comment.commentId.eq(commentId),
                        isDeletedCheck())
                .fetchFirst());
    }

    private BooleanExpression isDeletedCheck() {
        return comment.isDeleted.eq(false);
    }
}
