package com.example.demo.domain.comment.exception;

import com.example.demo.domain.comment.constant.CommentConstants;

public class NotFoundCommentException extends CommentException{
    public NotFoundCommentException(){
        super(CommentConstants.CommentExceptionList.NOT_FOUND_COMMENT.getErrorCode(),
                CommentConstants.CommentExceptionList.NOT_FOUND_COMMENT.getHttpStatus(),
                CommentConstants.CommentExceptionList.NOT_FOUND_COMMENT.getMessage()
        );
    }
}
