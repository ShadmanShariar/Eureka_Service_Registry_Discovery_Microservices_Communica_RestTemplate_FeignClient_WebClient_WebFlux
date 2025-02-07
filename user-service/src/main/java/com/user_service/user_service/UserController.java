package com.user_service.user_service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class  UserController {
    @GetMapping
    public String registration(){
        return "User";
    }
}
