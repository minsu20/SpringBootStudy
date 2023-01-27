package com.example.demo.common.factory;

import com.example.demo.domain.todo.dto.TodoDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TodoFactory {
    protected static LocalDateTime createdAt= LocalDateTime.now();

    private TodoFactory(){

    }
    public static class Builder{

    }

    public static List<TodoDto.CreateRequest> mockCreateRequest(){
        TodoDto.CreateRequest fixture1= TodoDto.CreateRequest.builder().
                title("제목1").description("내용1").tags(List.of("태그1", "태그2")).build();
        TodoDto.CreateRequest fixture2= TodoDto.CreateRequest.builder().
                title("제목2").description("내용2").tags(List.of("태그1", "태그2")).build();
        return List.of(fixture1, fixture2);
    }

    public static List<TodoDto.CreateResponse> mockCreateResponse(){
        List<String> tags1=List.of("태그1","태그2");
        TodoDto.CreateResponse fixture1= TodoDto.CreateResponse.builder().
                todoId(1).title("제목1").description("내용1").tags(tags1).isCompleted(false).createdAt(LocalDateTime.of(2023,1,28,20,50,10)).updatedAt(LocalDateTime.of(2023,1,28,20,50,10)).build();
        return List.of(fixture1);
    }
}
