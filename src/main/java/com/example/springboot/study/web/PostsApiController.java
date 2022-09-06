package com.example.springboot.study.web;

/*
B002 컨트롤러를 먼저 만들면 어떻게 되는지 확인
    현재는 Serivice 쪽에서 사용하는 객체를 사용할 수 없기 때문에 에러 발생
    RESTful API를 정의하기만 했다.
        /api/v1/posts

   Service가 저장소에서 가져오는 데이터 구조를 정의하지 않았기 때문에 더 이상 코드 진행 불가능
   따라서
   Service쪽의 코드를 작성하러 가야한다.

   최종적으로 코드개발 순서

   DTO --> Service --> Controller 순서로 작업해야 한다.

   study.service.posts.PostsService.java
 */

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;

    // localhost:8080/api/v1/posts

    @PostMapping("/api/v1/posts")
    public Long save()
    {
        return 0L;
    }
}
