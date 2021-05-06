package com.hyun.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor  // 기본 생성자 자동 추가
@Entity // 테이블과 링크될 클래스
public class Posts {

    @Id //해당 테이블의 PK 필드
    // PK의 생성 규칙으로 GenerationType.IDENTITY 은 auto_increment 의미
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 테이블의 칼럼이며 굳이 선언하지 않아도 이 클래스의 필드는 모두 칼럼이 됨
    // 기본값 외에 추가 설정 옵션을 직접 하기 위해 선언
    // 문자열은 VARCHAR(255)가 기본값인데 해당 코드에서는 사이즈를 500으로 늘리려고 함
    @Column(length = 500, nullable = false)
    private String title;

    // 타입을 TEXT로 변경
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;
    private String author;

    // 해당 클래스의 빌더 패턴 클래스 생성. 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
    // 생성자와 빌더는 둘 다 생성 시점에 값을 채워주는 역할을 똑같음
    // 생성자의 경우 지금 채워야 할 필드가 무엇인지 명확히 지정할 수가 없음
    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
