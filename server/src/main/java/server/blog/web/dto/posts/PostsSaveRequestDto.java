package server.blog.web.dto.posts;

import lombok.Getter;
import lombok.NoArgsConstructor;
import server.blog.domain.posts.Posts;

@NoArgsConstructor
@Getter
public class PostsSaveRequestDto {

    private String title;
    private String content;
    private Long isNotice;
    private Long isPrivate;

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .isNotice(isNotice)
                .isPrivate(isPrivate)
                .build();
    }
}