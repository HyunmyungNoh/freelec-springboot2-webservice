package com.hyun.book.springboot.web;

import com.hyun.book.springboot.web.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// JUnit에 내장된 실행자가 아닌 SpringRunner라는 스프링 실행자를 사용하여 스프링 부트 테스트와 JUnit의 연결자
@RunWith(SpringRunner.class)
// WebMVC에 집중하여 @Controller, @ControllerAdvice 등을 사용할 수 있음(service, repository 등은 아님)
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

    @Autowired  // 스프링이 관리하는 Bean을 주입 받음
    private MockMvc mvc;    // 웹 API를 테스트할 때 사용함. 스프링 MVC 테스트 시작점. HTTP, GET, POST 등 API 테스트 가능

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))  // MockMvc를 통해 /hello 주소로 GET 요청. 체이닝이 지원됨
                .andExpect(status().isOk()) // mvc.perform의 결과를 검증함. HTTP header의 Status(200, 404, 500..)중 200(ok)인지 검증
                .andExpect(content().string(hello));    // mvc.perform 응답 본문의 내용을 검증함. controller에서 "hello"를 리턴하는데 이 값이 맞는지
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto").param("name", name).param("amount", String.valueOf(amount)))
                // API 테스트 시 사용될 요청 인자를 설정. 값은 String만 허용되므로 int 형 변환
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))    // JSON 응답값을 필드별로 검증 가능한 메서드. $을 기준으로 필드명 명시
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}
