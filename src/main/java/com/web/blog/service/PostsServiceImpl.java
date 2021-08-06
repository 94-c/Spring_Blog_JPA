package com.web.blog.service;

import com.web.blog.model.Posts;
import com.web.blog.model.Users;
import com.web.blog.paging.Paged;
import com.web.blog.paging.Paging;
import com.web.blog.repository.PostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsServiceImpl implements PostsService{

    private final PostsRepository postsRepository;


    // 글 등록
    @Override
    @Transactional
    public void register(Users users, Posts posts) throws Exception {
        posts.setUsers(users);
        postsRepository.save(posts);
    }

    // 글 조회
    @Override
    @Transactional
    public Posts read(Integer id) throws Exception {
        System.out.println("글 조회화기 : " + id);
        return postsRepository.findById(id).orElseThrow(()->{
            return new IllegalArgumentException("글 상세보기 실패");
        });

    }

    // 글 수정
    @Override
    @Transactional
    public void modify(Users users, Posts posts) throws Exception {
        Posts post = postsRepository.getById(posts.getId());

        post.setUsers(users);
        post.setTitle(posts.getTitle());
        post.setContent(posts.getContent());

        System.out.println("글 수정하기 : " + posts);
    }

    // 글 삭제
    @Override
    @Transactional
    public void remove(Integer id) throws Exception {
        System.out.println("글 삭제하기 : " + id);
        postsRepository.deleteById(id);
    }

    // 글 목록
    @Override
    @Transactional(readOnly = true)
    public Paged<Posts> getPage(int pageNumber, int size) throws Exception {
        PageRequest request = PageRequest.of(pageNumber - 1, size, Sort.Direction.DESC, "id");
        Page<Posts> postPage = postsRepository.findAll(request);
        return new Paged<>(postPage, Paging.of(postPage.getTotalPages(), pageNumber, size));
    }


}
