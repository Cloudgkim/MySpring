package com.example.springboot.study.web.dto;

/*
A006 롬복 확인
    @Getter :get method()자동 실행
    @RequiredArgsConstructor
        선언된 final field 가 포함된 생성자를 자동생성

    DTO : Data Transfer Object
    생성된 Getter를 단위테스트로 확인
        test /  web/dto/HelloResponseDtoTest.java를 만들어야 한다.
 */

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class HelloResponseDto {
    private final String name;
    private final int age;


    /*
    public HelloResponseDto()
    {

    }

    public HelloResponseDto(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    HelloResponseDto dto = new HelloResponseDto("Hello", 12);
     */
}
