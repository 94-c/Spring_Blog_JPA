package com.web.blog.service;

import com.web.blog.dto.CommentsDTO;

import javax.persistence.criteria.CriteriaBuilder;

public interface CommentsService {

    //댓글 작성
    void commentSave(CommentsDTO commentsDTO);
}
