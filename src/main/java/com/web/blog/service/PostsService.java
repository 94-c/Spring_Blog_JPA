package com.web.blog.service;

import com.web.blog.model.Posts;
import com.web.blog.model.Users;
import com.web.blog.paging.Paged;

public interface PostsService {

    //등록처리
    void register(Users users, Posts posts) throws Exception;

    //상세 화면
    Posts read(Integer id) throws Exception;

    //수정 처리
    void modify(Users users, Posts posts) throws Exception;


    //삭제 처리
    void remove(Integer id) throws Exception;

    //페이징
    Paged<Posts> getPage(int pageNumber, int size) throws Exception;
}
