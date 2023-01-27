package com.example.demo.domain.todo.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

public class TodoConstansts {

    @Getter
    @RequiredArgsConstructor
    public enum ETodoController{
        LOCATION_ID_PATH("/{id}"),
        GET_METHOD("get"),
        DELETE_METHOD("delete"),
        UPDATE_METHOD("update");
        private final String value;
    }

    @Getter
    @RequiredArgsConstructor
    public enum EBoardResponseMessage{
        CREATE_TODO_SUCCESS("할일을 등록했습니다."),
        GET_ALL_TODO_SUCCESS("할일을 작성 순으로 조회했습니다."),
        GET_BYID_TODO_SUCCESS("할일을 검색해 조회했습니다"),
        UPDATE_TODO_SUCCESS("할일을 수정했습니다."),
        COMPLETE_TODO_SUCCESS("할일을 완료했습니다"),
        DELETE_TODO_SUCCESS("할일을 삭제했습니다"),
        SEARCH_BYTITLE_TODO_SUCCESS("할일을 제목으로 검색했습니다");
        private final String message;
    }

    @Getter
    @RequiredArgsConstructor
    public enum BoardExceptionList {
        NOT_FOUND_TODO("T0001", HttpStatus.NOT_FOUND, "해당 TodoIDd로 TODO를 찾을 수 없습니다.");
        private final String errorCode;
        private final HttpStatus httpStatus;
        private final String message;
    }
}
