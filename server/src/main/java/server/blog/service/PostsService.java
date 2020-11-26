package server.blog.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import server.blog.domain.posts.Posts;
import server.blog.domain.posts.PostsRepository;
import server.blog.web.dto.posts.PostsResponseDto;
import server.blog.web.dto.posts.PostsSaveRequestDto;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getPostId();
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 포스트가 없습니다."));

        return new PostsResponseDto(entity);
    }

    public Long update(Long id, PostsSaveRequestDto requestDto) {
        Posts entity = postsRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 포스트가 없습니다."));

        entity.update(requestDto.getTitle(), requestDto.getContent(),
                requestDto.getIsPrivate(), requestDto.getIsNotice());

        return entity.getPostId();
    }

    public Long delete(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 포스트가 없습니다."));

        postsRepository.delete(entity);

        return id;
    }
}
