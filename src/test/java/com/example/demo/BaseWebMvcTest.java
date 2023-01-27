package com.example.demo;

import com.example.demo.domain.todo.controller.TodoController;
import com.example.demo.domain.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest({
        TodoController.class
})

public abstract class BaseWebMvcTest extends BaseTest{

    @MockBean
    protected TodoService todoService;

    @Autowired
    protected MockMvc mockMvc;
}
