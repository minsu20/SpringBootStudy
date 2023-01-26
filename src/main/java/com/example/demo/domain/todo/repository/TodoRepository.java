package com.example.demo.domain.todo.repository;

import com.example.demo.domain.todo.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Integer>, TodoRepositoryCustom {
}
