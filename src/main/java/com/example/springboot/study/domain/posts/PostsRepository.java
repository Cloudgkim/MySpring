package com.example.springboot.study.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/*
A013 인터페이스
Alt-Enter
    JPA에서는 Repository라고 부른다.
    JpaRepository<클래스, PK>상속만하면 기본적으로 CRUD 메소드가 자동 생성
    Entity 클래스인 Posts와 Entity Repository인 PostsRepository는 같은 위치에 있어야 한다.
    이 저장소가 만들어지는데 단위테스트를 해보겠습니다.
    PostsRepositoryTest : 패키지 구조도 같아야함.

 C008
    목록에 보여줄 posts 객체를 만들기 위해서,
    데이터베이스에서 가져오는 순서를 결정해 줘야 한다.
    이때 사용하는 쿼리가 조금 다릅니다. : JPQL 검색

    JPQL이라고도 하고, Named SQL이라는 문법
    Posts AS p  : AS 는 써도 그만, 안써도 그만

    이때 SELECT 다음에 p가 일치해야 한다.
    쿼리에 맞는 데이터를 가져와서 List 컬렉션에 넣어 줍니다.

    findAllDesc()에서 역순으로 가져와 List에 붙여 넣는데.
    findAllDesc()에 의해 생성된 List객체인 Posts 정보를 응답처리하기 위해서
    DTO객체가 필요하다.
    이 객체를 Repository에서 가져와 실제 List로 뽑아내는 Service를 처리해 줘야한다.
    실제 처리는 PostsListResponseDTO -> Service -> Controller
    dto -> PostsListResponseDto.java를 만들어야 한다.
 */
public interface PostsRepository extends JpaRepository<Posts, Long> {
    // C008일때 추가됩니다.

    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}
