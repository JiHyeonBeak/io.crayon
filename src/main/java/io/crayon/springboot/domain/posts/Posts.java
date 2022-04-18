package io.crayon.springboot.domain.posts;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor  // 기본 생성자 자동 추가
@Entity // 테이블과 연결될 클래스임을 나타낸다.
public class Posts {

    @Id     // 해당 테이블의 PK(기본키)를 나타낸다.
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // 기본키 생성규칙을 정의한다.
    private Long id;

    @Column(length = 500, nullable = false)  // 선언하는 모든 필드가 컬럼이되지만, 옵션을 설정하려고 할 경우 컬럼 어노테이션을 쓴다.
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder    // 해당 클래스의 빌더 패턴 클래스를 생성한다.
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}

