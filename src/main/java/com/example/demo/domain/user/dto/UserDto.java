package com.example.demo.domain.user.dto;

import com.querydsl.core.annotations.QueryProjection;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

public abstract class UserDto {

    @Getter
    @AllArgsConstructor
    @Builder
    @ApiModel(description="회원가입을 위한 요청객체")
    public static class SignupRequest{
        @NotBlank(message = "이메일을 입력해주세요")
        @ApiModelProperty(notes="이메일을 입력해주세요")
        private String email;

        @NotBlank(message = "비밀번호를 입력해주세요")
        @ApiModelProperty(notes="비밀번호를 입력해주세요")
        private String password;

        @NotBlank(message = "이름을 입력해주세요")
        @ApiModelProperty(notes= "이름을 입력해주세요")
        private String userName;
    }

    @Getter
    @Builder
    @ApiModel(description="회원가입을 위한 응답객체")
    public static class SignupResponse{
        private String email;

        @QueryProjection
        public SignupResponse(String email){
            this.email=email;
        }
    }
}
