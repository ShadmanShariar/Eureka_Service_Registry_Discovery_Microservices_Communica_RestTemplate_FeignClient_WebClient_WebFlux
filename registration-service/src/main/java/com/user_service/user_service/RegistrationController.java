package com.user_service.user_service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registration")
public class RegistrationController {
    @GetMapping
    public String registration(){
        return "Reg";
    }
    @GetMapping("/{name}")
    public String getName(@PathVariable String name){
        return "Welcome "+name;
    }
}
