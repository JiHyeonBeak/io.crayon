package io.crayon.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter     // 선언된 모든 필드의 게터를 만들어준다.
@RequiredArgsConstructor    // final로 선언된 모든 필드의 생성자를 만들어준다.
public class HelloResponseDto {
    private final String name;
    private final int amount;
}
