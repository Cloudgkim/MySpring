package com.example.springboot.study.web.dto;

/*
C009
    DTO 처리가 끝나면 Repository에서 데이터를 가져와 DTO로 만들어주는 Service를 수정하러 갑니다.
    servcie.posts.PostsService
 */

import com.example.springboot.study.domain.posts.Posts;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostsListResponseDto {
    private  Long id;
    private String title;
    private String author;
    private LocalDateTime modifiedDate;

    public PostsListResponseDto(Posts entity)
    {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.modifiedDate = entity.getModifiedDate();
    }

}
