package com.example.springboot.study.service.posts;

import com.example.springboot.study.domain.posts.Posts;
import com.example.springboot.study.domain.posts.PostsRepository;
import com.example.springboot.study.web.dto.PostsListResponseDto;
import com.example.springboot.study.web.dto.PostsResponseDto;
import com.example.springboot.study.web.dto.PostsSaveRequestDto;
import com.example.springboot.study.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/*
B003 study.service.posts.PostsService.java

PostsSaveRequestDto를 파라미터로 Controller로부터 수신한 Service는 DB에 저장(save())한다.
Controller와 마찬가지로 생성자를 통한 주입을 위해 @RequiredArgsContrutor를 맨 위에 사용한다.

Service 객체한테 저장하라 save()라는 명령을 수행하는
Controller 코드를 수정하러 가야한다.
    PostsApiController.java 로 가서 코드 수정
 */
@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto)
    {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    /*
    B009 : update() 메소드 추가
     */
    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto)
    {
        // repository에 수정하기를 수행
        Posts posts = postsRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("No Data .. id = " + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    // Response를 위해 id찾기
    // 업데이트를 주소창
    // localhost:8080/api/v1/posts/3
    public PostsResponseDto findById(Long id)
    {
        Posts entity = postsRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("No Data .. id = " + id));
        return new PostsResponseDto(entity);
    }

    /*
    C010
        리스트를 트랜잭션으로 가져올 때
        import org.springframework.transaction.annotation.Transactional;
        와 같이 springframework에서 제공하는 transaction을 사용해야한다.
        이전은 javax.transcation을 사용했었다.
        javax의 트랜잭션은 Option을 허용하지 않고,
        springframework의 트랜잭션은 Option을 허용하는데,
        옵션으로 readonly같은 것을 추가할 수 있다.

        DTO -> Service -> Controller 확인
        IndexController에 가서 필요한 코드를 추가해야 한다.
     */

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc(){
        return postsRepository
                .findAllDesc()
                .stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }


}
