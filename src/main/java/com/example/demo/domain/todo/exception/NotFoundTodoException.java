package com.example.demo.domain.todo.exception;

import com.example.demo.domain.todo.constant.TodoConstansts;

public class NotFoundTodoException extends TodoException {
    public NotFoundTodoException() {
        super(TodoConstansts.TodoExceptionList.NOT_FOUND_TODO.getErrorCode(),
                TodoConstansts.TodoExceptionList.NOT_FOUND_TODO.getHttpStatus(),
                TodoConstansts.TodoExceptionList.NOT_FOUND_TODO.getMessage()
        );
    }
}
