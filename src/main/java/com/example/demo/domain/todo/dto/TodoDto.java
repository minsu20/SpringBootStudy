package com.example.demo.domain.todo.dto;

import com.querydsl.core.annotations.QueryProjection;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class TodoDto {

    @Getter
    @AllArgsConstructor
    @Builder
    @ApiModel(description="햘일 등록을 위한 요청객체")
    public static class CreateRequest{
        @NotBlank(message="제목을 입력해주세요")
        @ApiModelProperty(notes="제목을 입력해주세요")
        private String title;

        @NotBlank(message="내용을 입력해주세요")
        @ApiModelProperty(notes="내용을 입력해주세요")
        private String description;

        private List<String> tags=new ArrayList<>();
    }

    @Getter
    @AllArgsConstructor
    @Builder
    @ApiModel(description="할일 등록을 위한 응답객체")
    public static class CreateResponse{
        private Integer todoId;
        private String title;
        private String description;
        private List<String> tags=new ArrayList<>();
        private boolean isCompleted;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
    }

    @Getter
    @AllArgsConstructor
    @Builder
    @ApiModel(description="할일 조회를 위한 응답객체")
    public static class GetTodo{
        private Integer todoId;
        private String title;
        private String description;
        private List<String> tags=new ArrayList<>();
        private boolean isCompleted;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
    }

    @Getter
    @AllArgsConstructor
    @Builder
    @ApiModel(description="할일 수정을 위한 요청객체")
    public static class UpdateRequest{
        private String title;

        private String description;

        private List<String> tags=new ArrayList<>();
    }

    @Getter
    @AllArgsConstructor
    @Builder
    @ApiModel(description="할일 수정을 위한 응답객체")
    public static class UpdateResponse{
        private Integer todoId;
        private String title;
        private String description;
        private List<String> tags=new ArrayList<>();
        private boolean isCompleted;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
    }

    @Getter
    @AllArgsConstructor
    @Builder
    @ApiModel(description="할일 완료를 위한 응답객체")
    public static class CompleteTodo{
        private Integer todoId;
        private String title;
        private String description;
        private List<String> tags=new ArrayList<>();
        private boolean isCompleted;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
    }

    @Getter
    @Builder
    @ApiModel(description="할일 전체 조회를 위한 응답객체")
    public static class GetAllTodo {
        private Integer todoId;
        private String title;
        private String description;
        private List<String> tags=new ArrayList<>();
        private boolean isCompleted;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        @QueryProjection
        public GetAllTodo(Integer todoId, String title, String description, List<String> tags,boolean isCompleted, LocalDateTime createdAt, LocalDateTime updatedAt) {
            this.todoId = todoId;
            this.title = title;
            this.description = description;
            this.tags=tags;
            this.isCompleted = isCompleted;
            this.createdAt = createdAt;
            this.updatedAt = updatedAt;
        }

    }

}
