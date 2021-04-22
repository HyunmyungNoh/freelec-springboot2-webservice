package com.hyun.book.springboot.web.dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void 롬복_기능_테스트() {
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        // assertj라는 테스트 검증 라이브러리의 검증 메서드. 검증 원하는 대상을 인자로 받고 체이닝 지원됨
        assertThat(dto.getName()).isEqualTo(name);
        // assertj의 동등 비교 메서드
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
