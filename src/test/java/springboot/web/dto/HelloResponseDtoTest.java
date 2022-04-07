package springboot.web.dto;

import io.crayon.springboot.web.dto.HelloResponseDto;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;   //  Junit에서 제공하는 것과 달리 추가 라이브러리가 필요없다.

public class HelloResponseDtoTest {

    @Test
    public void 롬복_기능_테스트() {
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name,amount);

        //then
        assertThat(dto.getName()).isEqualTo(name);  // 검증하고 싶은 대상을 메소드 인자로 받아서 검증한다.
        assertThat(dto.getAmount()).isEqualTo(amount);  // 메소드 체이닝
    }
}
