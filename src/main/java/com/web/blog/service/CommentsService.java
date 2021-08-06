package com.web.blog.service;

import com.web.blog.dto.CommentsDTO;
import com.web.blog.model.Comments;
import com.web.blog.paging.Paged;

import javax.persistence.criteria.CriteriaBuilder;

public interface CommentsService {

    //댓글 작성
    void commentSave(CommentsDTO commentsDTO) throws Exception;

    Paged<Comments> getList(int commentsPageNumber, int commentSize) throws Exception;


}
