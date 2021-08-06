package com.web.blog.service;

import com.web.blog.dto.CommentsDTO;
import com.web.blog.model.Comments;
import com.web.blog.paging.Paged;
import com.web.blog.paging.Paging;
import com.web.blog.repository.CommentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentsServiceImpl implements CommentsService{

    private final CommentsRepository commentsRepository;

    //댓글 작성
    @Override
    @Transactional
    public void commentSave(CommentsDTO commentsDTO) throws Exception{
        commentsRepository.commentSave(commentsDTO.getUsersId(), commentsDTO.getPostsId(), commentsDTO.getComment());
    }

    @Override
    public Paged<Comments> getList(int commentsPageNumber, int commentSize) throws Exception {
        PageRequest pageRequest = PageRequest.of(commentsPageNumber -1, commentSize, Sort.Direction.DESC, "id");
        Page<Comments> commentsPage = commentsRepository.findAll(pageRequest);
        return new Paged<>(commentsPage, Paging.of(commentsPage.getTotalPages(), commentsPageNumber, commentSize));
    }

   /* @Override
    @Transactional
    public Paged<Comments> getList(int commentsPageNumber, int commentSize) throws Exception {
        PageRequest pageRequest = PageRequest.of(commentsPageNumber -1, commentSize, Sort.Direction.DESC, "id");
        Page<Comments> commentsPage = commentsRepository.findAll(pageRequest);
        return new Paged<>(commentsPage, Paging.of(commentsPage.getTotalPages(), commentsPageNumber, commentSize));
    }*/
}
