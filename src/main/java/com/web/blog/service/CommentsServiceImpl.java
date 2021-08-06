package com.web.blog.service;

import com.web.blog.dto.CommentsDTO;
import com.web.blog.model.Users;
import com.web.blog.repository.CommentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CommentsServiceImpl implements CommentsService{

    private final CommentsRepository commentsRepository;

    //댓글 작성
    @Override
    @Transactional
    public void commentSave(CommentsDTO commentsDTO) {
        commentsRepository.commentSave(commentsDTO.getUsersId(), commentsDTO.getPostsId(), commentsDTO.getComment());
    }
}
