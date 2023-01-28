package com.example.demo.domain.todo.controller;

import com.example.demo.BaseWebMvcTest;
import com.example.demo.common.factory.TodoFactory;
import com.example.demo.domain.todo.constant.TodoConstansts;
import com.example.demo.domain.todo.dto.TodoDto;
import com.example.demo.domain.todo.service.TodoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class TodoControllerTest extends BaseWebMvcTest {
    @DisplayName("할일 작성 테스트-성공")
    @Test
    void createTodoTest_success() throws Exception {
        //given
        TodoDto.CreateResponse createResponse = TodoFactory.mockCreateResponse().get(0);
        given(todoService.createTodo(any(TodoDto.CreateRequest.class))).willReturn(createResponse);

        //when
        ResultActions perform = mockMvc.perform(multipart("/todos")
                .param("title", "todoTitle")
                .param("description", "description")
                .param("tags", String.valueOf((List.of("tags1", "tags2")))));

        perform.andExpect(status().isCreated())
                .andExpect(jsonPath("$.message").value(containsString(TodoConstansts.ETododResponseMessage.CREATE_TODO_SUCCESS.getMessage())))
                .andExpect(jsonPath("$.data.todoId").value(is(1)))
                .andExpect(jsonPath("$.data.title").value(is("todoTitle")))
                .andExpect(jsonPath("$.data.description").value(is("description")))
                .andExpect(jsonPath("$.data.tags").value(is(List.of("tags1", "tags2"))))
                .andExpect(jsonPath("$.data.isCompleted").value(is(false)))
                .andExpect(jsonPath("$.data.createdAt").value(is("2023-01-28T20:50:10")))
                .andExpect(jsonPath("$.data.updatedAt").value(is("2023-01-28T20:50:10")))
                .andDo(print());
        then(this.todoService).should().createTodo(any(TodoDto.CreateRequest.class));


    }
}
