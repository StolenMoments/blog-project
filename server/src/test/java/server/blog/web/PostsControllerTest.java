package server.blog.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
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
    @Order(1)
    public void 게시글_테스트_GET() throws Exception {
        String mvcResultString = mvc.perform(get("/api/posts/1"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        println(mvcResultString);
    }


    @Test
    @Order(2)
    @Transactional
    public void 게시글_테스트_POST() throws Exception {
        ObjectNode content = objectMapper.createObjectNode();
        content.put("title", "제목 테스트 입니다");
        content.put("content", "내용 테스트");
        content.put("isNotice", 0);
        content.put("isPrivate", 0);

        String mvcResultString = mvc.perform(
                post("/api/posts")
                        .content(objectMapper.writeValueAsString(content))
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        println(mvcResultString);
    }


    @Test
    @Order(3)
    @Transactional
    public void 게시글_테스트_PUT() throws Exception {
        ObjectNode content = objectMapper.createObjectNode();
        content.put("title", "제목 UPDATE 테스트 입니다");
        content.put("content", "내용 UPDATE 테스트");
        content.put("isNotice", 0);
        content.put("isPrivate", 0);

        String mvcResultString = mvc.perform(
                put("/api/posts/1")
                        .content(objectMapper.writeValueAsString(content))
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        assertEquals(mvcResultString, "1");
    }


    @Test
    @Order(4)
    @Transactional
    public void 게시글_테스트_DELETE() throws Exception {
        String mvcResultString = mvc.perform(delete("/api/posts/1"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        assertEquals(mvcResultString, "1");
    }

}