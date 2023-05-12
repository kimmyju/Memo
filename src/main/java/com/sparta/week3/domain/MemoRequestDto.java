package com.sparta.week3.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
//@Setter은 필요 없음
@RequiredArgsConstructor
public class MemoRequestDto {
    private String username; //final이 붙으면 상속 불가능한 클래스가 됨
    private String contents;
}
