package com.web.blog.service;

import com.web.blog.model.Users;
import org.springframework.validation.Errors;

import java.util.Map;


public interface UsersService {

    // 로그인 기능
    Users findByEmailAndPassword(String email, String password);

    // 회원가입 처리
    void join(Users users) throws Exception;

   // 유효성 검사
    Map<String, String> validateHanding(Errors errors);

    int emailCheck(String email) throws  Exception;

}
