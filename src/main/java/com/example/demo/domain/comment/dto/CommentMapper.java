package com.example.demo.domain.comment.dto;

import com.example.demo.domain.comment.entity.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = CommentMapperSupport.class)
public interface CommentMapper {
    @Mapping(target = "content", source = "createRequest.content")
    Comment toEntity(CommentDto.CreateRequest createRequest);

    @Mapping(target = "commentId", source = "commentId")
    @Mapping(target = "content", source = "content")
    @Mapping(target = "createdAt", source = "createdAt")
    @Mapping(target = "updatedAt", source = "updatedAt")
    CommentDto.CreateResponse toCreateDto(Comment comment);

    @Mapping(target = "commentId", source = "commentId")
    @Mapping(target = "content", source = "content")
    @Mapping(target = "createdAt", source = "createdAt")
    @Mapping(target = "updatedAt", source = "updatedAt")
    CommentDto.GetResponse toGetDto(Comment comment);

    @Mapping(target = "commentId", source = "commentId")
    @Mapping(target = "content", source = "content")
    @Mapping(target = "createdAt", source = "createdAt")
    @Mapping(target = "updatedAt", source = "updatedAt")
    CommentDto.UpdateResponse toUpdateDto(Comment comment);
}
