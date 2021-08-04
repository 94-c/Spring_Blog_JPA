package com.web.blog.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto_increment;
    private Integer id;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private Users users;

    @Column(nullable = false, length = 100)
    private String title;

    private String slug;

    @Lob
    private String content;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime created_at;

    @LastModifiedDate
    private LocalDateTime updated_at;

    @OneToMany(mappedBy = "posts", fetch = FetchType.EAGER)
    @JsonIgnoreProperties({"posts"})
    @OrderBy("id desc")
    private List<Comments> comments;

}
