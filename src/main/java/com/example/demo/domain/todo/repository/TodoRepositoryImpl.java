package com.example.demo.domain.todo.repository;

import com.example.demo.domain.todo.dto.QTodoDto_GetAllTodo;
import com.example.demo.domain.todo.dto.TodoDto;
import com.example.demo.domain.todo.entity.Todo;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.impl.JPAUpdateClause;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;


import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.example.demo.domain.todo.entity.QTodo.todo;
import static com.example.demo.domain.comment.entity.QComment.comment;

public class TodoRepositoryImpl implements TodoRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    private final EntityManager em;

    public TodoRepositoryImpl(EntityManager em) {
        this.em= em;
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public Optional<Todo> findNotDeletedByTodoId(Integer todoId) {
        return Optional.ofNullable(queryFactory.selectFrom(todo)
                .where((todo.todoId.eq(todoId)),
                        isDeletedCheck())
                .fetchFirst());
    }

    private BooleanExpression isDeletedCheck() {
        return todo.isDeleted.eq(false);
    }

    @Override
    public Page<TodoDto.GetAllTodo> findAllTodosByCreatedDate(Pageable pageable){

                List<Todo> content2=queryFactory
                .selectFrom(todo)
                .where(isDeletedCheck())
                .orderBy(todo.createdAt.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        List<TodoDto.GetAllTodo> content=content2.stream().map(c->new TodoDto.GetAllTodo(c.getTodoId(),c.getTitle(),c.getDescription(),c.getTags(),c.isCompleted(),c.getCreatedAt(),c.getUpdatedAt())).collect(Collectors.toList());

        JPAQuery<Todo> count=queryFactory
                .selectFrom(todo)
                .where(isDeletedCheck())
                .orderBy(todo.createdAt.desc());

        return PageableExecutionUtils.getPage(content, pageable, ()->count.fetchCount());
    }

    @Override
    public void deleteCommentByTodo(Integer todoId){
        JPAUpdateClause updateClause=new JPAUpdateClause(em, comment);
        updateClause.where(comment.todo.todoId.eq(todoId))
                .set(comment.isDeleted, true)
                .execute();
    }

    @Override
    public List<TodoDto.GetAllTodo> findTodoByTItle(String title){
        List<Todo> content2=queryFactory
                .selectFrom(todo)
                .where(isDeletedCheck())
                .where(todo.title.contains(title))
                .orderBy(todo.createdAt.desc())
                .fetch();

        List<TodoDto.GetAllTodo> content=content2.stream().map(c->new TodoDto.GetAllTodo(c.getTodoId(),c.getTitle(),c.getDescription(),c.getTags(),c.isCompleted(),c.getCreatedAt(),c.getUpdatedAt())).collect(Collectors.toList());
        return content;
    }

}
