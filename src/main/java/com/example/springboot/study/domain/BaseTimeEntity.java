package com.example.springboot.study.domain;

/*
B013 domain.BaseTimeEntity.java
    @MappedSuperclass
        JPA Entity Class들이 BaseTimeEntity를 상속하는 경우에 필드 (createDate, modifiedDate)도 컬럼으로 인식하게하라

    @EntityListeners(AuditingEntityListener.class)
        BaseTime Entity 클래스에 Auditing 기능을 포함시키겠다.

    @CreatedDate
        Entity가 생성되어 저장될 때 시간이 자동으로 저장

    @LastModifiedDate
        Entity가 값을 변경할 때 시간이 자동으로 저장

    할 일
        Posts 클래스가 BaseTimeEntity 클래스를 상속하도록 변경하게 되면
            createDate, modifiedDate필드가 추가되면서
            모든 Posts의 시간정보(생성, 변경)를 감시한다.
            추상클래스이기 때문에 extends로 추가하러 가면 된다.
 */

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {
    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;
}
