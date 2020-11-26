package server.blog.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import server.blog.service.PostsService;
import server.blog.web.dto.posts.PostsResponseDto;
import server.blog.web.dto.posts.PostsSaveRequestDto;

@Api(tags = {"Posts Controller"})
@RestController
@AllArgsConstructor
@CrossOrigin
public class PostsController {

    private final PostsService postsService;

    @ApiOperation(value = "게시글 조회")
    @GetMapping("/api/posts/{id}")
    private PostsResponseDto findById(@PathVariable("id") Long id) {
        return postsService.findById(id);
    }

    @ApiOperation(value = "게시글 저장")
    @PostMapping("/api/posts")
    private Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @ApiOperation(value = "게시글 수정")
    @PutMapping("/api/posts/{id}")
    private Long update(@PathVariable("id") Long id, @RequestBody PostsSaveRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @ApiOperation(value = "게시글 삭제")
    @DeleteMapping("/api/posts/{id}")
    private Long delete(@PathVariable("id") Long id) {
        return postsService.delete(id);
    }

}
