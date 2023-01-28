package com.example.demo.domain.user.exception;

import com.example.demo.domain.user.constant.UserConstants;

public class OverlapUserException extends UserException{

    public OverlapUserException(){
        super(UserConstants.BoardExceptionList.OVERLAP_USER.getErrorCode(),
                UserConstants.BoardExceptionList.OVERLAP_USER.getHttpStatus(),
                UserConstants.BoardExceptionList.OVERLAP_USER.getMessage());
    }
}
