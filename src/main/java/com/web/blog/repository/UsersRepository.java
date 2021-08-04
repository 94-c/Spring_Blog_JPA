package com.web.blog.repository;

import com.web.blog.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UsersRepository extends JpaRepository<Users, Integer> {

    // 로그인
    @Query(value = "SELECT * FROM users WHERE email = ? AND password = ?", nativeQuery = true)
    Users findByEmailAndPassword(String email, String password);

    @Query(value = "SELECT COUNT(*) FROM users WHERE email = #{email}", nativeQuery = true)
    Integer emailCheck(String email);




}
