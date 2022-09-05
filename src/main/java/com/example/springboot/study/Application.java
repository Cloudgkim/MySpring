package com.example.springboot.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
    A001
    @SpringBootApplication
        스프링 부트의 자동 설정
        스프링 Bean 읽기와 생성을 모두 자동으로 설정
        이 어노테이션이 있는 위치부터 설정을 읽는다.
        프로젝트의 최 상단에 위치!!

        main()에서 프로그램이 시작된다.
        내장된(Built-in) WAS(Web Application Server)로 Tomcat을 기본으로 지원

        Controller를 만든다.

        File - Settins - Editor - General - Code Completion -> Match Case 해제

 */
@SpringBootApplication
public class Application {
    public static void main(String[] args)
    {
        SpringApplication.run(Application.class, args);
    }
}
