package com.example.demo.domain.comment.exception;

import com.example.demo.global.exception.ApplicationException;
import org.springframework.http.HttpStatus;

public abstract class CommentException extends ApplicationException {
    protected CommentException(String errorCode, HttpStatus httpStatus, String message) {
        super(errorCode, httpStatus, message);
    }
}
