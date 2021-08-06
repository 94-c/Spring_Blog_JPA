package com.web.blog.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
public class CommentsDTO {

    @NotBlank
    private Integer id;

    @NotBlank
    private Integer usersId;

    @NotBlank
    private Integer postsId;

    @NotBlank
    private String comment;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    @Override
    public String toString() {
        return "CommentsDTO{" +
                "id=" + id +
                ", usersId=" + usersId +
                ", postsId=" + postsId +
                ", comment='" + comment + '\'' +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }
}
