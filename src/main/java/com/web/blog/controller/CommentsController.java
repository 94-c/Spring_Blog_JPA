package com.web.blog.controller;

import com.web.blog.dto.CommentsDTO;
import com.web.blog.service.CommentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
public class CommentsController {

    private final CommentsService commentsService;

    //댓글 작성
    @PostMapping("/comment/writer")
    public String commentWriter(CommentsDTO commentsDTO){
        System.out.println(commentsDTO.toString());
        try {
            commentsService.commentSave(commentsDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/read/"+ commentsDTO.getPostsId() ;
    }

    @GetMapping("/comments")
    public String read(@RequestParam(value = "commentsPageNumber", required = false, defaultValue = "1")int pageNumber,
                       @RequestParam(value = "commentSize", required = false, defaultValue = "5") int size, Model model) throws Exception{
        model.addAttribute("comments", commentsService.getList(pageNumber, size));
        return "/comments/list";
    }


}
