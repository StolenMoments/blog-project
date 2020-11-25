package server.blog.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
public class PostsControllerTest extends AbstractControllerTest {

    @Autowired
    private PostsController postsController;

    @Autowired
    private ObjectMapper objectMapper;

    private void println(String str) {
        System.out.println(str);
    }

    @Override
    protected Object controller() {
        return postsController;
    }

    @Test
    public void 게시글_테스트_GET() throws Exception {
        String mvcResultString = mvc.perform(get("/api/posts/1"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        println(mvcResultString);

    }

    @Test
    @Transactional
    public void 게시글_테스트_POST() throws Exception {
        ObjectNode content = objectMapper.createObjectNode();
        content.put("title", "제목 테스트 입니다");
        content.put("content", "내용 테스트");
        content.put("isNotice", 0);
        content.put("isPrivate", 0);

        mvc.perform(
                post("/api/posts")
                        .content(objectMapper.writeValueAsString(content))
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk());

    }
}