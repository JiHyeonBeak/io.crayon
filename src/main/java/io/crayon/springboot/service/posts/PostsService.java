package io.crayon.springboot.service.posts;

import io.crayon.springboot.domain.posts.PostsRepository;
import io.crayon.springboot.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor    // final이 선언된 모든 필드를 생성자로 만든다
@Service
public class PostsService {

    private final PostsRepository postsRepository;  // Autowired 보단 생성자로 주입하는 것을 권장

    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }
}
