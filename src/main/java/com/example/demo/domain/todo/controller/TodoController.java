package com.example.demo.domain.todo.controller;

import com.example.demo.domain.todo.constant.TodoConstansts;
import com.example.demo.domain.todo.constant.TodoConstansts.ETodoController;
import com.example.demo.domain.todo.constant.TodoConstansts.ETododResponseMessage;
import com.example.demo.domain.todo.dto.TodoDto;
import com.example.demo.domain.todo.dto.TodoDto.*;
import com.example.demo.domain.todo.service.TodoService;
import com.example.demo.global.dto.PaginationDto;
import com.example.demo.global.dto.ResponseDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("todos")
@Api(tags="Todo API")
public class TodoController {
    private final TodoService todoService;

    @ApiOperation(value = "할일 작성", notes = "할일을 작성합니다.")
    @PostMapping
    public ResponseEntity<ResponseDto<CreateResponse>> createTodo(@Valid @ModelAttribute CreateRequest createRequest){
        CreateResponse createResponse=this.todoService.createTodo(createRequest);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path(ETodoController.LOCATION_ID_PATH.getValue())
                .buildAndExpand(createResponse.getTodoId())
                .toUri();
        return ResponseEntity.created(location).body(ResponseDto.create(ETododResponseMessage.CREATE_TODO_SUCCESS.getMessage(), createResponse));
    }


    @ApiOperation(value = "할일 읽기", notes = "할일을 읽습니다")
    @GetMapping("/{todoId}")
    public ResponseEntity<ResponseDto<GetTodo>> getTodo(@PathVariable Integer todoId){
        return ResponseEntity.ok(ResponseDto.create(ETododResponseMessage.GET_BYID_TODO_SUCCESS.getMessage(),this.todoService.getById(todoId)));
    }


    @ApiOperation(value="할일 수정", notes="할일을 수정합니다")
    @PutMapping("/{todoId}")
    public ResponseEntity<ResponseDto<UpdateResponse>> updateTodo(@PathVariable Integer todoId, @ModelAttribute UpdateRequest updateRequest){
        return ResponseEntity.ok(ResponseDto.create(ETododResponseMessage.UPDATE_TODO_SUCCESS.getMessage(),this.todoService.updateById(todoId, updateRequest)));
    }

    @ApiOperation(value="할일 완료", notes="할일을 완료합니다")
    @PutMapping("/{todoId}/complete")
    public ResponseEntity<ResponseDto<CompleteTodo>> completeTodo(@PathVariable Integer todoId){
        return ResponseEntity.ok(ResponseDto.create(ETododResponseMessage.COMPLETE_TODO_SUCCESS.getMessage(),this.todoService.completeById(todoId)));
    }


    @ApiOperation(value="할일 삭제", notes="할일을 삭제합니다")
    @DeleteMapping("/{todoId}")
    public ResponseEntity<ResponseDto> deleteTodo(@PathVariable Integer todoId){
       this.todoService.deleteTodo(todoId);
       return ResponseEntity.ok(ResponseDto.create(ETododResponseMessage.DELETE_TODO_SUCCESS.getMessage()));
    }

    @ApiOperation(value = "할일을 작성 순으로 조회", notes = "할일을 작성 시간순으로 조회합니다")
    @GetMapping
    public ResponseEntity<ResponseDto<PaginationDto<List<GetAllTodo>>>> getTodo(@PageableDefault Pageable pageable){
        return ResponseEntity.ok(ResponseDto.create(ETododResponseMessage.GET_ALL_TODO_SUCCESS.getMessage(),this.todoService.getAll(pageable)));
    }

    @ApiOperation(value="할일을 제목으로 검색", notes="할일을 제목으로 검색합니다")
    @GetMapping("search/{title}")
    public ResponseEntity<ResponseDto<List<GetAllTodo>>> getByTitle(@PathVariable String title){
        return ResponseEntity.ok(ResponseDto.create(ETododResponseMessage.SEARCH_BYTITLE_TODO_SUCCESS.getMessage(),this.todoService.findByTitle(title)));
    }


}
