package com.web.blog.service;

import com.web.blog.model.Users;
import com.web.blog.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;


@RequiredArgsConstructor
@Service
public class UsersServiceImpl implements UsersService {


    private final UsersRepository usersRepository;

    // 로그인
    @Override
    @Transactional
    public Users findByEmailAndPassword(String email, String password) {
        return usersRepository.findByEmailAndPassword(email, password);
    }

    /*@Override
    @Transactional
    public Users join(String email, String password, String name, String address, String phone) {
        System.out.println("" + email + password + name + address + phone);
        return usersRepository.join(email,password,name,address,phone);
    }*/

    @Override
    @Transactional
    public Map<String, String> validateHanding(Errors errors){
        Map<String, String> validatorResult = new HashMap<>();

        for(FieldError error : errors.getFieldErrors()){
            String validKeyName = String.format("valid_%s", error.getField());
            validatorResult.put(validKeyName, error.getDefaultMessage());
        }
        return validatorResult;
    }

    @Override
    public int emailCheck(String email) throws Exception {
        return usersRepository.emailCheck(email);
    }

    // 회원가입
    @Override
    @Transactional
    public void join(Users users) throws Exception {
        usersRepository.save(users);
    }




}
