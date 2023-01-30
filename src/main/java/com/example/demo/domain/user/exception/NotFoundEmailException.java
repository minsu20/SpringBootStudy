package com.example.demo.domain.user.exception;

import com.example.demo.domain.user.constant.UserConstants;

public class NotFoundEmailException extends UserException {
    public NotFoundEmailException() {
        super(UserConstants.UserExceptionList.NOT_FOUND_EMAIL.getErrorCode(),
                UserConstants.UserExceptionList.NOT_FOUND_EMAIL.getHttpStatus(),
                UserConstants.UserExceptionList.NOT_FOUND_EMAIL.getMessage());
    }
}
