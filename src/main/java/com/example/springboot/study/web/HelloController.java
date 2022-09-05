package com.example.springboot.study.web;

/*
A002 RESTful API

    http://test.com/main.jsp?name=test&age=12
    http://test.com/main.jsp/user/2?name=hong
    http://test.com/hello

    METHOD
        GET  : HTTP Header 정보가 날라간다
            http://test.com/login.jsp?id=test&pass=1234
            1. 보안상의 심각한 문제 발생
            2. 메시지 길이가 정해져있다.(255B)

            http://test.com/hello

            http://test.com/show.jsp?id=3
        POST : HTTP Body 에 정보가 날라간다.

        DELETE
        PUT

    @RestController
        JSON(JavaScript Object Notation)로 반환하는 컨트롤로 만들때
 */

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("hello")
    public String hello()
    {
        return "hello";
    }

    @GetMapping("test")
    public String test()
    {
        return "테스트를 결과로 준다.";
    }

}
