package io.crayon.springboot.web;

import io.crayon.springboot.web.dto.HelloResponseDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller // JSON을 반환하는 컨트롤러를 선언
public class HelloController {

    @GetMapping("/hello")   // Get 요청에 대한 Mapping
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name,@RequestParam("amount") int amount) {
        /* RequestParam 외부에서 API로 넘긴 파라미터를 가져오는 어노테이션.
         name으로 넘어온 값을 String name에 저장 */
        return new HelloResponseDto(name,amount);
    }
}
