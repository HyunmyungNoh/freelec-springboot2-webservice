package com.hyun.book.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter // 선언된 모든 필드의 get 메소드를 생성해 줍니다.
// 선언된 모든 final 필드가 포함된 생성자를 생성해 줌. final이 없는 필드는 생성자에 포함되지 않음
@RequiredArgsConstructor
public class HelloResponseDto {
    // 테스트 시 오류가 나서 gradle 버전을 다음 명령어로 다운그레이드함
    // gradlew wrapper --gradle-version 4.10.2
    private final String name;
    private final int amount;
}

