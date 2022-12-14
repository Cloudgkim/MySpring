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

import com.example.springboot.study.service.posts.PostsService;
import com.example.springboot.study.web.dto.PostsResponseDto;
import com.example.springboot.study.web.dto.PostsSaveRequestDto;
import com.example.springboot.study.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


/*
    B004
        서버스에 RequestDTO를 파라미터로 해서 Serive에 저장 명령 수행

        스프링부트는 메소드를 구분해서 사용하는 것이 일반적이다.
        GET     : 데이터 요청,   GET
        POST    : 저장하라..,   POST
        PUT     : 수정    ,    POST
        DELETE  : 삭제 ,       GET

       현재까지는 논리적으로 저장이 되는 것을 코딩 => 확인
       단위테스트를 통해서 확인할 수 있다.
       PostsApiController를 테스트할 것이니까
       PostsApiControllerTest.java를 만들어서 단위테스트 하자.
 */
@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;

    // localhost:8080/api/v1/posts

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto)
    {
        return postsService.save(requestDto);
    }

    /*
    B010 수정하기 Mapping 추가

            GET : 보여줘 : http://localhost:8080/api/v1/posts/3

            주의할 점 :
                Create : POST
                Update : PUT
            @PathVariable (경로를 변수화하는 역할)
            @GetMapping("/api/v1/posts/{id}") 에서
                {id}를 변수화하여 @PathVariable Long id에 매핑하는 역할

          ===> 단위 테스트 : PostsApiControllTest.java에 가서 단위테스트 시도
     */
    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id,
                       @RequestBody PostsUpdateRequestDto requestDto)
    {
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id)
    {
        return postsService.findById(id);
    }
}
