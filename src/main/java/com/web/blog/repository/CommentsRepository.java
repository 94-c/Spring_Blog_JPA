package com.web.blog.repository;

import com.web.blog.model.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CommentsRepository extends JpaRepository<Comments, Integer> {

    @Modifying
    @Query(value = "INSERT INTO comments(user_id, post_id, comment, created_at) VALUES(?1, ?2, ?3, now())", nativeQuery = true)
    Integer commentSave(Integer userid, Integer postid, String comment);
}
