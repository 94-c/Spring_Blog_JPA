package com.web.blog.service;

import com.web.blog.dto.CommentsDTO;
import com.web.blog.model.Comments;
import com.web.blog.paging.Paged;

public interface CommentsService {

    //λκΈ μμ±
    void commentSave(CommentsDTO commentsDTO) throws Exception;

    Paged<Comments> getList(int commentsPageNumber, int commentSize) throws Exception;


}
