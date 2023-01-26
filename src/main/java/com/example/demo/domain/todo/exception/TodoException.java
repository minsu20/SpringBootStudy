package com.example.demo.domain.todo.exception;

import com.example.demo.global.exception.ApplicationException;
import org.springframework.http.HttpStatus;

public abstract class TodoException extends ApplicationException {
    protected TodoException(String errorCode, HttpStatus httpStatus, String message) {
        super(errorCode, httpStatus, message);
    }
}
