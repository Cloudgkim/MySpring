package com.example.springboot.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

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

   A004
    전체 프로그램을 한번 실행해보기

        웹서버가 동작 하고 확인을 위해
        http://localhost:8080/hello
        했을 때, 화면에 hello가 나와야 정상

    Class와 DB를 매핑시켜준다.
        Class - Getter, Setter를 자동으로 처리해 주는 라이브러리를 설치 : Lombok
        롬복
            Getter, Setter, Default Constructor, toString() 등을 Annotaion으로 자동 생성

            Ctrl-Shift-A => plugins에서 롬복 확인

            File > Settings > Build, Executing, Depl... > Complier > Annotation Processors >
                Enable annotation processing 체크

     PHP
        http://test.com/main.php?id=test
        http://test.com/api/show/21

 */

/*
B015 Auditing을 하고 있다고 알려줘야 한다.
    Just Add
        @EnableJpaAuditing
 */
@EnableJpaAuditing
@SpringBootApplication
public class Application {
    public static void main(String[] args)
    {
        SpringApplication.run(Application.class, args);
    }
}
