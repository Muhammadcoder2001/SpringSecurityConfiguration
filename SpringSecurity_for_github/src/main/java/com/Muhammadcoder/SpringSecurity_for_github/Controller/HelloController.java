package com.Muhammadcoder.SpringSecurity_for_github.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(HttpServletRequest request) {
        return "Hello Muhammadcoder  " + request.getSession().getId();
    }

}
