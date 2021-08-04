package com.web.blog.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post_tags {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Posts posts;  //posts에 id와 연관관계

    @ManyToOne
    @JoinColumn(name = "tag_id")
    private Tags tags;  //tags에 id와 연관 관계
}
