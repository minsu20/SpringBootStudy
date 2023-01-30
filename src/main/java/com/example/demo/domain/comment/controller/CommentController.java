package com.example.demo.domain.comment.controller;

import com.example.demo.domain.comment.constant.CommentConstants;
import com.example.demo.domain.comment.dto.CommentDto;
import com.example.demo.domain.comment.dto.CommentDto.CreateResponse;
import com.example.demo.domain.comment.dto.CommentDto.GetResponse;
import com.example.demo.domain.comment.dto.CommentDto.UpdateResponse;
import com.example.demo.domain.comment.service.CommentService;
import com.example.demo.global.dto.ResponseDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("todos")
@Api(tags = "Comment API")
public class CommentController {

    private final CommentService commentService;

    @ApiOperation(value = "댓글 등록", notes = "댓글을 등록합니다")
    @PostMapping("/{todoId}/comments")
    public ResponseEntity<ResponseDto<CreateResponse>> createComment(@PathVariable Integer todoId, @Valid @ModelAttribute CommentDto.CreateRequest createRequest) {
        return ResponseEntity.ok(ResponseDto.create(CommentConstants.ECommentResponseMessage.CREATE_COMMENT_SUCCESS.getMessage(), this.commentService.createComment(todoId, createRequest)));
    }

    @ApiOperation(value = "댓글 목록", notes = "할일 아이디로 댓글 목록을 조회합니다")
    @GetMapping("/{todoId}/comments")
    public ResponseEntity<ResponseDto<List<GetResponse>>> getComment(@PathVariable Integer todoId) {
        return ResponseEntity.ok(ResponseDto.create(CommentConstants.ECommentResponseMessage.GET_ALL_DETAIL_COMMENTS_SUCCESS.getMessage(), this.commentService.getCommentByTodoId(todoId)));
    }

    @ApiOperation(value = "댓글 삭제", notes = "댓글을 삭제합니다")
    @DeleteMapping("/{todoId}/comments/{commentId}")
    public ResponseEntity<ResponseDto> deleteComment(@PathVariable Integer todoId, @PathVariable Integer commentId) {
        this.commentService.deleteComment(todoId, commentId);
        return ResponseEntity.ok(ResponseDto.create(CommentConstants.ECommentResponseMessage.DELETE_COMMENT_SUCCESS.getMessage()));
    }

    @ApiOperation(value = "댓글 읽기", notes = "댓글을 단건 조회합니다.")
    @GetMapping("/{todoId}/comments/{commentId}")
    public ResponseEntity<ResponseDto<GetResponse>> getComment(@PathVariable Integer todoId, @PathVariable Integer commentId) {
        return ResponseEntity.ok(ResponseDto.create(CommentConstants.ECommentResponseMessage.GET_COMMENTS_SUCCESS.getMessage(), this.commentService.getComment(todoId, commentId)));
    }

    @ApiOperation(value = "댓글 수정", notes = "댓글을 수정합니다.")
    @PutMapping("/{todoId}/comments/{commentId}")
    public ResponseEntity<ResponseDto<UpdateResponse>> updateComment(@PathVariable Integer todoId, @PathVariable Integer commentId, @Valid @ModelAttribute CommentDto.UpdateRequest updateRequest) {
        return ResponseEntity.ok(ResponseDto.create(CommentConstants.ECommentResponseMessage.UPDATE_COMMENTS_SUCCESS.getMessage(), this.commentService.updateComment(todoId, commentId, updateRequest)));
    }
}
