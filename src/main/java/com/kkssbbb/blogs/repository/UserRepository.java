package com.kkssbbb.blogs.repository;

import com.kkssbbb.blogs.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

//db에인서트하기위해 만든 인터페이스
// JpaRepository 는 User테이블이 관리하는 레파지토리이고, 유저테이블의 프라이머리키는 인티저(숫자)이다.
//자동으로 Bean등록이가능해서 @Repository 생략가능하다.
public interface UserRepository extends JpaRepository<User,Integer> {
}
