package com.web.blog.controller;

import com.web.blog.dto.UsersDTO;
import com.web.blog.model.Users;
import com.web.blog.repository.UsersRepository;
import com.web.blog.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Map;
import java.util.Objects;

@RequiredArgsConstructor
@Controller
public class UsersController {

    private final UsersService usersService;

    private final UsersRepository usersRepository;

    // 로그인 뷰
    @GetMapping("/login")
    public String loginView(Users users, Model model){

        model.addAttribute("users", users);

        return "users/login";
    }
    
    // 로그인 기능
    @PostMapping("/login")
    public String login(@ModelAttribute("users") Users users, RedirectAttributes rttr, HttpSession session){
        Users User = usersService.findByEmailAndPassword(users.getEmail(), users.getPassword());

        System.out.println(">>> login" + User);

        if(Objects.nonNull(User)){
            rttr.addFlashAttribute("msg", "로그인이 완료되었습니다.");
            session.setAttribute("User", User);
            return "redirect:/";
        }else {
            rttr.addFlashAttribute("msg", "로그인이 실패하였습니다.");
            return "redirect:/login";
        }

    }

    // 로그아웃 기능
    @GetMapping("/logout")
    public String logout(RedirectAttributes rttr, HttpSession session){
        session.invalidate();
        rttr.addFlashAttribute("msg", "로그아웃이 완료되었습니다");
        return "redirect:/";
    }


    // 회원가입 뷰
    @GetMapping("/user/join")
    public String joinView(Users users, Model model){
        model.addAttribute("users", users);
        return "/users/join";
    }

    // 회원가입 기능

    @PostMapping("/user/join")
    public String join(@Valid UsersDTO usersDTO, Errors errors, Model model, RedirectAttributes rttr) throws Exception {
        if (errors.hasErrors()) {
            model.addAttribute("usersDTO", usersDTO);

            Map<String, String> validatorResult = usersService.validateHanding(errors);

            for (String key : validatorResult.keySet()) {
                model.addAttribute(key, validatorResult.get(key));
            }
        return "/users/join";
        }
        usersService.join(usersDTO.join());
        rttr.addFlashAttribute("msg", "회원가입이 완료되었습니다.");
        return "redirect:/";


    }

    // 이메일 중복체크
    @ResponseBody
    @PostMapping("/emailCheck")
    public int emailCheck(@RequestBody String email) throws Exception{
        int count = 0;
        if(email != null) count = usersService.emailCheck(email);
        return count;
    }

    // 회원정보 조회
    @GetMapping("/user/detail")
    public String detail() throws Exception{
        return "/users/detail";
    }




}
