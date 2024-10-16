package com.Muhammadcoder.SpringSecurity_for_github.Controller;

import com.Muhammadcoder.SpringSecurity_for_github.Entity.Users;
import com.Muhammadcoder.SpringSecurity_for_github.Service.UsersService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {

    private final UsersService service;
    public UsersController(UsersService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public Users register(@RequestBody Users user) {
        return service.register(user);
    }


}
