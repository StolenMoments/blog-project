package server.blog.web.dto.posts;

import lombok.Getter;
import server.blog.domain.posts.Posts;

import java.time.LocalDateTime;

@Getter
public class PostsResponseDto {

    private final String title;
    private final String content;
    private final LocalDateTime datetime;
    private final Long isNotice;
    private final Long isPrivate;
    private final Long hit;

    public PostsResponseDto(Posts entity) {
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.datetime = entity.getDatetime();
        this.isNotice = entity.getIsNotice();
        this.isPrivate = entity.getIsPrivate();
        this.hit = entity.getHit();
    }
}


