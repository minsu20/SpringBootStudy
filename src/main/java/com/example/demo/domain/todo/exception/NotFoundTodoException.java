package com.example.demo.domain.todo.exception;

import com.example.demo.domain.todo.constant.TodoConstansts;

public class NotFoundTodoException extends TodoException{
    public NotFoundTodoException(){
        super(TodoConstansts.BoardExceptionList.NOT_FOUND_TODO.getErrorCode(),
                TodoConstansts.BoardExceptionList.NOT_FOUND_TODO.getHttpStatus(),
                TodoConstansts.BoardExceptionList.NOT_FOUND_TODO.getMessage()
        );
    }
}
