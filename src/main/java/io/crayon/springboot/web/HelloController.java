package io.crayon.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller // JSON을 반환하는 컨트롤러를 선언
public class HelloController {

    @GetMapping("/hello")   // Get 요청에 대한 Mapping
    public String hello() {
        return "hello";
    }
}
