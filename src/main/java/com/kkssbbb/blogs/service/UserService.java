package com.kkssbbb.blogs.service;

import com.kkssbbb.blogs.model.RoleType;
import com.kkssbbb.blogs.model.User;
import com.kkssbbb.blogs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//@Service : 스프링이 컴포넌트 스캔을 통해서 bean에 등록을 해준다(Ioc 가 되게끔)
@Service
public class UserService {

    @Autowired  //DI를 해준다.
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder encoder; 

    @Transactional // : 1트랜잭션 관리, 2서비스 의미 때문 :ex 한번에 두개의 트랜잭션션을 관할 수 있다
    public void 회원가입(User user) {


        String rawPassword =user.getPassword(); //1234원문
        String encPassword = encoder.encode(rawPassword);//해쉬화
        user.setPassword(encPassword);
        user.setRole(RoleType.USER);
        userRepository.save(user);
    }

    }

