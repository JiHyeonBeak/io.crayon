package io.crayon.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts,Long> {
    // DB 접근자 a.k.a DAO, jpa에서는 리포지토리로 부르고 인터페이스로 생성한다.
    // JpaRepository<엔티티 클래스, pk키>를 상속하면 기본적인 CRUD 메소드는 생성된다.
    // entity클래스와 함께 위치해야한다.
}
