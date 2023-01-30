package com.example.demo.domain.user.repository;

import com.example.demo.domain.user.dto.QUserDto_SignupResponse;
import com.example.demo.domain.user.dto.UserDto;
import com.example.demo.domain.user.entity.User;
import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.persistence.EntityManager;

import java.util.Optional;

import static com.example.demo.domain.todo.entity.QTodo.todo;
import static com.example.demo.domain.user.entity.QUser.user;

public class UserRepositoryImpl implements UserRepositoryCustom{
    private final JPAQueryFactory queryFactory;

    public UserRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public Optional<User> findByEmail(String email){
        return Optional.ofNullable(queryFactory.selectFrom(user)
                .where(user.email.eq(email))
                .fetchFirst());
    }
}
