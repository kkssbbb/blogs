package com.kkssbbb.blogs.hendler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler { //예외 처리 페이지

    @ExceptionHandler(value = Exception.class)
    public String handleArgumentException(Exception e){
        return"<h1>" + e.getMessage()+"</h1>";
    }
}
