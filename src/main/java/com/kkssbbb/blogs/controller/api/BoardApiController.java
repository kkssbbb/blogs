package com.kkssbbb.blogs.controller.api;

import com.kkssbbb.blogs.config.auth.PrincipalDetail;
import com.kkssbbb.blogs.dto.ResponseDto;
import com.kkssbbb.blogs.model.Board;
import com.kkssbbb.blogs.model.User;
import com.kkssbbb.blogs.service.BoardService;
import com.kkssbbb.blogs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
public class BoardApiController {


    @Autowired
    private BoardService boardService;

    @PostMapping("/api/board")
    public ResponseDto<Integer> save(@RequestBody Board board, @AuthenticationPrincipal PrincipalDetail principal) {
        boardService.글쓰기(board, principal.getUser());
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);

    }

    @DeleteMapping("/api/board/{id}")
    public ResponseDto<Integer> deleteById(@PathVariable int id) {
        System.out.println("삭제하기"+id);
    boardService.글삭제하기(id);
    return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }
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

