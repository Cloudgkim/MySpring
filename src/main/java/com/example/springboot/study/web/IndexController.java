package com.example.springboot.study.web;

import com.example.springboot.study.service.posts.PostsService;
import com.example.springboot.study.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/*
B017 IndexController
    이거 만들고, 단위 테스트

    http://localhost:8080/

    @Controller : 클래스 타입에 적용
        이것을 붙이면 해당 클래스를 웹 요청 처리하는 컨트롤러로 사용하게 된다.

 */
@RequiredArgsConstructor  // C011에서 추가
@Controller
public class IndexController {

    /*
    // C011 이전 코드
    @GetMapping("/")
    public String index() {
        return "index";
    }
     */

    /*
    C011 에서 서비스의 findAllDesc()의 결과를 index.mustache에서 사용할 수 있는 posts객체로 만들어준다.
     */
    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model)
    {
        // posts 로 만들어주기
        model.addAttribute("posts", postsService.findAllDesc());
        return "index";
    }

    /*
    C003
     */
    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    /*
    C013 /posts/show/1 처리
     */
    @GetMapping("/posts/show/{id}")
    public String postShow(@PathVariable Long id, Model model)
    {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("posts", dto);
        return "posts-show";
    }

    /*
    C018 : /posts/update/1 글 수정하기 화면을 만들어준다.
     */

    @GetMapping("/posts/update/{id}")
    public String postUpdate(@PathVariable Long id, Model model)
    {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("posts", dto);
        return "posts-update";
    }


}
