package com.web.blog.service;

import com.web.blog.dto.CommentsDTO;

import javax.persistence.criteria.CriteriaBuilder;

public interface CommentsService {

    void commentSave(CommentsDTO commentsDTO);
}
