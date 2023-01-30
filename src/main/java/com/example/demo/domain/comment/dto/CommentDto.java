package com.example.demo.domain.comment.dto;

import com.querydsl.core.annotations.QueryProjection;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public abstract class CommentDto {
    @Getter
    @AllArgsConstructor
    @Builder
    @ApiModel(description = "댓글 등록을 위한 요청객체")
    public static class CreateRequest {
        @NotBlank
        private String content;
    }

    @Getter
    @AllArgsConstructor
    @Builder
    @ApiModel(description = "댓글 등록을 위한 응답객체")
    public static class CreateResponse {
        private Integer commentId;
        private String content;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
    }

    @Getter
    @Builder
    @ApiModel(description = "댓글 조회를 위한 응답객체")
    public static class GetResponse {
        private Integer commentId;
        private String content;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        @QueryProjection
        public GetResponse(Integer commentId, String content, LocalDateTime createdAt, LocalDateTime updatedAt) {
            this.commentId = commentId;
            this.content = content;
            this.createdAt = createdAt;
            this.updatedAt = updatedAt;
        }
    }

    @Getter
    @AllArgsConstructor
    @Builder
    @ApiModel(description = "댓글 수정을 위한 요청객체")
    public static class UpdateRequest {
        @NotBlank
        private String content;
    }

    @Getter
    @AllArgsConstructor
    @Builder
    @ApiModel(description = "댓글 수정을 위한 응답객체")
    public static class UpdateResponse {
        private Integer commentId;
        private String content;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
    }


}
