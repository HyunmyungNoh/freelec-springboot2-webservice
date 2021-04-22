package com.hyun.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication이 있는 위치부터 설정을 읽어가기 때문에 이 annotation이 붙은 클래스는 항상 프로젝트 최상단에 위치
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
