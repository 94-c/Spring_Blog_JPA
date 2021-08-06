package com.web.blog.controller;

import com.web.blog.dto.CommentsDTO;
import com.web.blog.model.Posts;
import com.web.blog.model.Users;
import com.web.blog.service.CommentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class CommentsController {

    private final CommentsService commentsService;

    //댓글 작성
    @PostMapping("/comment/writer")
    public String commentWriter(CommentsDTO commentsDTO){
        System.out.println(commentsDTO.toString());
        commentsService.commentSave(commentsDTO);
        return "redirect:/read/"+ commentsDTO.getPostsId() ;
    }
}
