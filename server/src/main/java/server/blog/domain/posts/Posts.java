package server.blog.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Entity
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    private Long hit;
    private LocalDateTime datetime;
    private String title;
    private String content;
    private Long isNotice;
    private Long isPrivate;

    @Builder
    public Posts(String title, String content, Long isNotice, Long isPrivate) {
        this.title = title;
        this.content = content;
        this.isNotice = isNotice;
        this.isPrivate = isPrivate;
        this.datetime = LocalDateTime.now();
        this.hit = 0L;
    }

    public void update(String title, String content, Long isPrivate, Long isNotice) {
        this.title = title;
        this.content = content;
        this.isNotice = isNotice;
        this.isPrivate = isPrivate;
        this.datetime = LocalDateTime.now();
    }

}
