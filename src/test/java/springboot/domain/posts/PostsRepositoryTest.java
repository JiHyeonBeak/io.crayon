package springboot.domain.posts;

import io.crayon.springboot.domain.posts.Posts;
import io.crayon.springboot.domain.posts.PostsRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {
    
    @Autowired
    PostsRepository postsRepository;
    
    @After  // Junit에서 단위테스트가 끝날때마다 실행할 메소드
    public void cleanup() {
        postsRepository.deleteAll();
    }
    @Test
    public void 게시글저장_불러오기() {
        //given
        String title = "테스트 게시글";
        String content = "본문";
        
        postsRepository.save(Posts.builder()    // postRepository의 insert,update를 실행한다. id값이 있으면 update, 없으면 insert
                .title(title)
                .content(content)
                .author("Monny")
                .build());
        
        //when
        List<Posts> postsList = postsRepository.findAll();  // 테이블의 모든 데이터 조회
        
        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
        
    }
    
}
