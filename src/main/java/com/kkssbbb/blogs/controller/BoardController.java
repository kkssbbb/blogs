package com.kkssbbb.blogs.controller;

import com.kkssbbb.blogs.config.auth.PrincipalDetail;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

    @GetMapping({"","/"})
    public String index(){
          //   /WEB-INF/views/user.bustache
        //System.out.println("로그인 사용자 아이디"+principal.getUsername());
        return "index";
    }
    //user권한 필요
    @GetMapping("/board/saveForm")
    public String saveForm(){
        return "board/saveForm";
    }
}
