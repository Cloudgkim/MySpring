Gradle Sync : Ctrl - Shift - O

모듈 설치 : Ctrl + Shift + A

GitHub 변경 테스트 커밋

A001 : Application.java
A002 : HelloController.java
A003 : test/HelloControllerTest.java
A004 : main/Application.java 실행
A005 : build.gradle에 롬복 추가
A006 : main/ web/dto/HelloResponseDto.java
A007 : src/ web/dto/HelloResponseDtoTest.java
A008 : build.grale에 롬복 상세 설정
A009 : HelloController.java
A010 : HelloControllerTest.java
A011 : build.gradle 에 JPA사용하겠다고 설정
A012 : domain.posts.Posts.java
A013 : domain.posts.PostsRepository.java interface를 만든다.
A014 : test/ domain.posts.PostsRepositoryTest.java
A015 : resources/application.properties 을 생성해서 로그를 남긴다.


    프로그램 개발 순서 : DTO -> Service -> Controller

B001 : web.dto.PostsSaveRequestDto.java
B002 : web.PostsApiController.java 이것을 먼저 만드는 것은 바람직하지 않음을 확인하기 위한 용도
B003 : study.service.posts.PostsService.java
B004 : web.PostsApiController.java PostsService에 DTO를 이용해 저장 명령 수행
B005 : test/web.PostsApiControllerTest.java에서 단위테스트
B006 : PostsUpdateRequestDto.java 수정하기 DTO
B007 : PostsResponseDto.java 응답을 위한 DTO
B008 : Posts.java에 update()메소드 추가
B009 : PostsService.java 에 update() 추가
B010 : PostsApiController.java 에 수정하기 Mapping 추가
B011 : PostsApiControllerTest.java에서 단위테스트
B012 : application.properties 에 H2DB console 설정
    spring.h2.console.enabled = true 설정후 Application을 실행
    http://localhost:8080/h2-console 에 접속
B013 : domain.BaseTimeEntity.java 추상클래스
B014 : Posts.java 가 BaseTimeEntity클래스를 상속받도록 기능 추가
B015 : Application.java에 Auditing을 알려준다.(어노테이션으로)
B016 : PostsRepositoryTest.java 에서 Auditing을 단위 테스트
Mustache를 위해 확인(설정)
    File > Setting > Editor > Code Style > File Types > Handlebars/Mustache > File Name Patters에
    *.mustache 이 등록되어 있어야 한다.
B017 : study.web.IndexController.java
B018 : IndexControllerTest.java 단위테스트
B019 : src/main/resources/templates/index.mustache

C001 : index.mustache : 글쓰기 버튼
C002 : posts-save.mustache  글쓰기 화면을 위한 HTML 페이지(Mustache Page)
C003 : IndexController.java 에 /posts/save를 등록
C004 : /resources/static/css/style.css
C005 : /resources/static/js/index.js
C006 : footer.mustache : index.js파일을 실행
    글쓰기 성공하면 http://localhost:8080/h2-console 에 접속해 데이터 확인
C007 : index.mustache 에 글 목록을 보여주겠습니다.
C008 : posts.PostsRepository.java : 목록에 보여줄 posts 객체를 만들어야 한다.
C009 : dto.PostsListResponseDto.java 리스트 객체를 전송하는 Dto만든다.
C010 : PostsService.java에서 posts 객체를 만들어서 보낸다.
C011 : IndexController.java : Service에서 전달한 DTO를 가져온 결과를 posts로 index.mustache에 전달하는 코드
C012 : index.mustcach 파일에서 제목에다 링크를 만들고 내용보기를 만들어야 한다.
C013 : IndexController.java : /posts/show/1 처리를 해준다.
C014 : posts-show.mustache : 글 내용보기하는 페이지를 만들어준다.
C015 : posts-show.mustache : 수정버튼에 이동할 페이지 작성
C016 : posts-update.mustache : 페이지를 만드는데, posts-save.mustache와 거의 같다. ( posts/update)
C017 : index.js : 실제 수정처리를 한다.
C018 : IndexController.java : 글 수정하기 화면을 구성하는 처리

Mustache 간단한 문법 정리
{{! comment }}

1. 변수 :  {{ 변수이름 }}

{
    "name": "홍길동",
    "age": 12,
    "title": "<table>",
}

{{ name }} -> {{! 홍길동 }}
{{ age }} -> {{! 12 }}
{{ company }} -> {{! none }}
{{ title }} --> &lt;table&gt;
{{{ title }}} --> <table>  태그를 그대로 써준다.


{
    "name": "홍길동",
    "age" : 12,
    "company" : {
        "name" : "임픽스",
        "http" : "http://impix.co.kr",
        "address" : "서울",
    },
}

{{ name }} : 홍길동
{{ age }}  : 12
{{ company.name }} : 임픽스
{{ company.http }} : http://impix.co.kr
{{ company }}

2. Section : 조건문, 반복문

    {{ #변수명 }}
    {{ #posts }}

    2-1 조건문

    {
        "name" : "홍길동"
    }

    {{#name}}
        이 사람의 이름은 {{name}}
    {{/name}}
    {{^name}}
        사람 정보가 없습니다.
    {{/name}}

    {
        "person": {
            "name":"홍길동",
            "age":12,
        },
        "company": {
            "name":"임픽스"
        }
    }

    {{#person}}
        {{name}}의 회사명은 {{company.name}}입니다.
    {{/person}}

    2-2 반복문

    {
        "member": [
            { "name":"홍길동", "age":12 },
            { "name":"이순신", "age":34 },
            { "name":"광개토", "age":56 }
        ]
    }

    {{#member}}
        {{name}}
    {{/member}}

    2-3 반전 섹션 : not ^
    {
        "member": [ ]
    }

    {{#member}}
        {{name}}
    {{/member}}
    {{^member}}
        사람이 없네.
    {{/member}}

3. 부분 템플릿 : Partial Template 기호 : >  , include
    Java: import
    C, PHP : include

    {{>layout/header}}

    {{#name}}
        {{>user}}
    {{/name}}

4. 구분자 : {{ , }}
    일반적으로 사용할 때,  {{variablename}}

    JSP: <%  %>
    PHP : <? ?>

    {{=<%   %>=}}


Mustache : 매우 간단한 템플릿 엔진
    ReAct 화면 틀을 미리 만들어 놓고, 특정 영역에 데이터베이스 정보를 출력
    자바 : 서버 템플릿 엔진을 사용
    JS : 클라이언트 템플릿 엔진

    장점 : 문법이 매우 단순 View 역할만 수행
        즉, 화면에 출력하는 부분만 담당
        IntelliJ에서는 plugin을 설치 간단

        Ctrl-Shift-A : 검색어 plugins
            mustache 검색해서 install한다.

            gradle.build에 추가해야하는데, 우리는 이미 추가해 놓았다.

    BootStrap
        w3schools.com


게시판
    id, title, content, author, 글쓴 시간, 글 최종 수정시간, 비밀번호, 사용자id, .....
    JPA Auditing 기술 제공
        글쓴 시간, 글 수정한 시간정보를 관리해야할 때, 시스템이 처리해주는 방법입니다.
        생성, 수정을 자동으로 감시(Auditing)하면서 데이터베이스를 이용하면 편리하다.
    insert into posts (title, content, author, time) values ('aaa', 'bbb', 'ccc', now());
    domain패키지에 BaseTimeEntity클래스를 생성해한다.




H2DB
    spring boot에서 제공하는 Built-in database
        별도의 설치가 필요없다.
        데이터베이스로 H2DB를 사용하겠다고 선언
    in-memory DB  ---------- Memory, 일상적인 배포용으로는 적합하지 않다.
                             개발용으로 매우 적합

    RDBMS         --------- File System
        Oracle
            + MySql
            + MariaDB
                + SQLite : SQL Light
            + MSSql
    Memory DB


JPA  : Java Persistence API : 자바 지속성 API
기존 MyBatis에서 SQL Mapper를 이용해서 DB쿼리를 작성하고는 했다.
--> 프로그램의 대부분이 SQL 작업하는 것이 일의 대부분
    SQL 처리하는 코드 작성하는 시간이 증가하는 문제
    객체지향적으로 처리할 수 있는 방법이 없을까?

    ORM(Object Relational Mapping)기술이 나왔는데,
    대표적인 것이 JPA이다.
    JPA는 표준 자바 ORM(프로그램 - JPA - DB의 인터페이스 역할)
    ORM은 객체를 매핑하고 SQL Mapper는 쿼리를 매핑
    SQL에 따른 종속성에서 벗어나겠다.

    JPA를 사용한다 = Java Collection에서 데이터를 넣었다 빼게 만들겠다.
    CRUD (Create, Read, Update, Delete)
        저장 : jpa.persit(객체)
        조회 : Member member = jpa.find(키)
        수정 : member.setName("변경할이름");
                String name ==> getName(), setName()
        삭제 : jpa.remove(member)

    장점 : 유지보수가 간단하다.
            객체가 변경되면, 알아서 DB에 Update Query수행해준다.
            기존 : 필드명이 변경되면 모든 SQL 수정

조회
+-----------------------------+
|  Java Application           |
|                             |
|     +------------------+    |
|     | JPA              |    |
|     | +--------------+ |    |            +---------+
|     | |  JDBC        + +----+---SQL--->  |   DB    |
|     | |  API         + +<---+---Ret----  |         |
|     | +--------------+ |    |            +---------+
|     +------------------+    |
+-----------------------------+


저장
+---------------------------------------------+
|                                             |
|   +-----------+              +------------+ |
|   |           |   (Entity)   | JPA        | |
|   |   Member  | --Persist -->|  +-------+ | |
|   |   DAO     |              |  | JDBC  | + +---(insert SQL) ---> DB
|   |           |              |  +-------+ | |
|   +-----------+              +------------+ |
|                                             |
+---------------------------------------------+

저장
+---------------------------------------------+
|                                             |
|   +-----------+              +------------+ |
|   |           |              | JPA        | |
|   |   Member  |--find(id)--->|  +-------+ | |                     +------+
|   |   DAO     |              |  | JDBC  | + +---(insert SQL) ---> |  DB  |
|   |           |    (entity)  |  | API   | | |<------ Ret -------- |      |
|   |           |<-- (object) -|  +-------+ | |                     +------+
|   +-----------+              +------------+ |
|                                             |
+---------------------------------------------+




JSON : JavaScript Object Notation

{
    "name": "홍길동",
    "age" : 12,
}

{   "name": "홍길동",  "age" : 12, }

{
    "name": "홍길동",
    "age" : 12,
    "company" : {
        "name" : "임픽스",
        "http" : "http://impix.co.kr",
        "address" : "서울",
    },
}

{
    "employee" : {
        "name" : "홍길동",
        "age" : 12,
     },
    "company" : {
        "name" : "임픽스",
        "http" : "http://impix.co.kr",
        "address" : "서울",
    },
}

{
    "employee" : [
        { "name": "홍길동", "age":12, "home":"서울",},
        { "name": "이순신", "age":22, "home":"경남",},
        { "name": "강감찬", "age":32, "home":"강원",},
        { "name": "광개토", "age":42, "home":"서울",},
    ],
    "company" : {
        "name" : "임픽스",
        "http" : "http://impix.co.kr",
        "address" : "서울",
    },
}