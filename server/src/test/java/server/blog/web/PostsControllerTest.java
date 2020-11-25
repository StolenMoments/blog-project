package server.blog.web;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
public class PostsControllerTest extends AbstractControllerTest {

    @Autowired
    private PostsController postsController;

    @Override
    protected Object controller() {
        return postsController;
    }

    @Test
    public void postsGetTest() throws Exception {
        mvc.perform(get("/api/posts/1"))
                .andExpect(status().isOk())
                .andDo(print());
    }
}