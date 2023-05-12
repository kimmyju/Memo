package com.sparta.week3.domain;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter//아래 멤버변수가 private가 되어 있는 부분이 있으므로 꼭 넣어줘야 함!!
@MappedSuperclass // Entity가 자동으로 컬럼으로 인식합니다.
@EntityListeners(AuditingEntityListener.class) // 생성/변경 시간을 자동으로 업데이트합니다.
public abstract class Timestamped {

    @CreatedDate//생성시간
    private LocalDateTime createdAt; //private로 선언하면 이데이터를 조회할 수 없음 즉 getter이 있어야지만 가능

    @LastModifiedDate//수정시간
    private LocalDateTime modifiedAt;

}

//abstract -->다른거랑 다 똑같지만 다른곳에서 상속이 되어야지만 빵을 만들 수 있음(new 사용 불가)