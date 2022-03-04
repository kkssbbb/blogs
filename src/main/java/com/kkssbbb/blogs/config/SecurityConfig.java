package com.kkssbbb.blogs.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration// 빈등록: 스프링 컨테이너에서 객체를 관리할 수 있게 한다.
@EnableWebSecurity //시큐리// 티 필터설정파일 지정 : 스프링 시큐리티 설정을 이 파일(SecurityConfig)에서 하겠다는 의미.
@EnableGlobalMethodSecurity(prePostEnabled = true) //특정 주소로 접근을 하면 권한 밎 인증을 미리 체크하겠다는 뜻.
//우 세개 어노테이션은 시큐리티 에서 세트 어노테이션
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/auth/**")
                .permitAll()//auth/이하는 누구나 들어올수 있다.
                .anyRequest() //다른요청은
                .authenticated() //인증이 되야한다.
                .and()
                .formLogin()
                .loginPage("/auth/loginForm");

    }
}
