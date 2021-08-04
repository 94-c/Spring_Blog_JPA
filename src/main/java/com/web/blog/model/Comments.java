package com.web.blog.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto_increment;
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;  //users에 id와 연관 관계

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Posts posts; //posts에 id와 연관 관계

    private String comment;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime created_at;

    @LastModifiedDate
    private LocalDateTime updated_at;
}
