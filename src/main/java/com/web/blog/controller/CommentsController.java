package com.web.blog.controller;

import com.web.blog.dto.CommentsDTO;
import com.web.blog.model.Posts;
import com.web.blog.model.Users;
import com.web.blog.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CommentsController {

    @Autowired
    private CommentsService commentsService;

    @PostMapping("/comment/writer")
    public String commentWriter(CommentsDTO commentsDTO){
        System.out.println(commentsDTO.toString());
        commentsService.commentSave(commentsDTO);
        return "redirect:/read/"+ commentsDTO.getPostsId() ;
    }
}
