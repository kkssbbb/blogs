package com.kkssbbb.blogs.controller.api;

import com.kkssbbb.blogs.dto.ResponseDto;
import com.kkssbbb.blogs.model.RoleType;
import com.kkssbbb.blogs.model.User;
import com.kkssbbb.blogs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
public class UserApiController {

    @Autowired
    private UserService userService;

    @PostMapping("/auth/joinProc")
    public ResponseDto<Integer> save(@RequestBody User user) {
        System.out.println("User ApiController : save호출됨 ");

        user.setRole(RoleType.USER);
        userService.회원가입(user);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);

    }

//    @PostMapping("/api/user/login")
//    public ResponseDto<Integer> login(@RequestBody User user, HttpSession session) {
//        System.out.println("UserApiController : login호출됨");
//        User principal = userService.로그인(user); // principal 접근주체
//
//        if(principal!=null){
//            session.setAttribute("principal",userService.로그인(user));
//        }
//        System.out.println("principal :"+ principal );
//
//        return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
//    }
}
