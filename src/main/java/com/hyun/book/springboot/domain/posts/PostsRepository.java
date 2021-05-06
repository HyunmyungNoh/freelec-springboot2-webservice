package com.hyun.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

//상속 시 인자로 Entity 클래스와 PK 타입을 보낸다
public interface PostsRepository extends JpaRepository<Posts, Long> {
}