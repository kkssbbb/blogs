package com.kkssbbb.blogs.test;

import com.kkssbbb.blogs.model.RoleType;
import com.kkssbbb.blogs.model.User;
import com.kkssbbb.blogs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //데이터 응답
public class DummyControllerTest {

    @Autowired //의존성주입(DI)
    private UserRepository userRepository;

    @PostMapping("/dummy/join")
    public String join(User user) {
        System.out.println("username : "+user.getUsername());
        System.out.println("password : "+user.getPassword());
        System.out.println("email : "+user.getPassword());

        user.setRole(RoleType.USER);
        userRepository.save(user);
        return "회원가입 완료";
    }
}
