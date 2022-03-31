package com.kkssbbb.blogs.controller;

import com.kkssbbb.blogs.config.auth.PrincipalDetail;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

//인증이 안된 사용자들이 출입할 수 있는 경로를 /auth/** 만 허용(인증이필요없는 곳)
//그냥 주소가 / 이면 index.jsp 허용
//static이하에 있는 /js/**,/css/**, /image/

@Controller
public class UserController {

    @GetMapping("/auth/joinForm")
    public String joinForm(){

        return "user/joinForm";
    }

    @GetMapping("/auth/loginForm")
    public String loginForm(){

        return "user/loginForm";
    }


    @GetMapping("/user/updateForm")
    public String updateForm() {

        return "user/updateForm";
    }

    @GetMapping("/auth/kakao/callback")
    public @ResponseBody String kakaoCallback(String code){ //@ResponseBody 를 붙이면 Data를 리턴해주는 컨트롤러 함수가 된다.

       //POST 방식으로 KEY=VALUE 데이터를 요청 (카카오쪽으로) -> RestTemplate 라이브러리 사용
        RestTemplate rt = new RestTemplate();

        //HttpHeader 오브젝트 생성
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

        //HttpBody 오브젝트 생성
        MultiValueMap<String,String> params = new LinkedMultiValueMap<>();
        params.add("grant_type","authorization_code");
        params.add("client_id","f8f3a4807dd82522d99c2a3e15986b9b"); //변수화 해서 사용하는게 더 좋은 코드지만 일단은 날 코딩
        params.add("redirect_uri","http://localhost:8000/auth/kakao/callback");
        params.add("code",code);

        // HttpHeader와 HttpBody를 하나의 오브젝트에 담기
        HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest =  //kakaoTokenRequest가 Body 값과 Hearder 값을 갖고 있는다.
                new HttpEntity<>(params, headers);

        // Http 요청하기 - Post방식으로 -그리고 response 변수의 응답 받음.
        ResponseEntity<String> response = rt.exchange(
                "https://kauth.kakao.com/oauth/token",
                HttpMethod.POST,
                kakaoTokenRequest,
                String.class
        );


        return  "카카오 인증 완료 , response응답 값 : " + response ;
    }

}
