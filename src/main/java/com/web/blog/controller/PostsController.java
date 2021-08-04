package com.web.blog.controller;

import com.web.blog.dto.ResponseDTO;
import com.web.blog.model.Posts;
import com.web.blog.model.Users;
import com.web.blog.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class PostsController {


    private final PostsService postsService;



    @GetMapping("/")
    public String index(@RequestParam(value = "pageNumber", required = false, defaultValue = "1") int pageNumber,
                        @RequestParam(value = "size", required = false, defaultValue = "5") int size, Model model) {
        try {
            model.addAttribute("posts", postsService.getPage(pageNumber, size));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "index";
    }


    // 글 등록 뷰
    @GetMapping("/register")
    public String registerForm() throws Exception{
        return "/posts/register";
    }

    // 글 등록 기능
    @PostMapping("/register")
    public ResponseDTO<Integer> register(@RequestBody Posts posts, HttpSession session, RedirectAttributes rttr) throws Exception{
        Users users = (Users) session.getAttribute("User");
        postsService.register(users, posts);
        return new ResponseDTO<Integer>(HttpStatus.OK.value(), 1);
    }


    // 상세보기
    @GetMapping("/read/{id}")
    public String read(@PathVariable Integer id, Model model, HttpSession session) throws Exception{
        model.addAttribute("posts", postsService.read(id));
        System.out.println("글 상세보기 : " + id);
        return "/posts/read";
    }

    // 수정 화면
    @GetMapping("/modify")
    public String modifyForm(Integer id, Model model) throws Exception{
        model.addAttribute(postsService.read(id));
        return "/posts/modify";
    }

    // 수정 처리 기능
    @PostMapping("/modify")
    public String modify(Posts posts, RedirectAttributes rttr,  HttpSession session) throws Exception{
        Users users = (Users)session.getAttribute("User");
        postsService.modify(users, posts);
        rttr.addFlashAttribute("msg", "수정이 완료되었습니다.");
        return "redirect:/";
    }


    // 삭제 기능
    @PostMapping("/remove")
    public String remove(Integer id, RedirectAttributes rttr) throws Exception{
        postsService.remove(id);
        rttr.addFlashAttribute("msg", "삭제가 완료되었습니다.");
        return "redirect:/";
    }



}