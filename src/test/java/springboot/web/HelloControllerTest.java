package springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import springboot.web.dto.HelloResponseDtoTest;
import static org.hamcrest.Matchers.is;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)    // 테스트 실행자로 SpringRunner를 사용하겠다고 선언. 스프링부트 테스트와 JUnit과의 연결자
@WebMvcTest(controllers = HelloController.class)    // 스프링 웹 테스트에 집중할 수 있는 어노테이션. 서비스,컴포넌트,리포지토리 어노테이션은 사용불가.
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;    // 웹 API를 테스트 할 때 사용, 스프링 MVC 테스트의 시작점이다.

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))  // MockMvc를 통해/hello로 GET요청을 한다.
                .andExpect(status().isOk()) // 헤더의 Status를 검증한다. 200인지...
                .andExpect(content().string(hello)); // 컨트롤러의 리턴값을 검증
    }

    @Test
    public void HelloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000 ;

        mvc.perform(
                get("/hello/dto")
                        .param("name",name) // API테스트를 위한 요청 파라미터 설정. String만 허용된다.
                        .param("amount",String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name",is(name))) // Json Response를 필드별로 검증할 수 있는 메소드. $를 기준으로 필드를 구분한다.
                .andExpect(jsonPath("$.amount",is(amount)));
    }
}
