package com.user_service.user_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/user")
public class  UserController {

    private RestTemplate restTemplate;
    @Autowired
    private RegistrationService registrationService;
    public UserController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public String registration(){
        return "User";
    }

    //Calling Another Microservice Using Rest Template
//    @GetMapping("/{name}")
//    public String getName(@PathVariable String name){
//        String result = restTemplate.getForObject("http://REGISTRATION-SERVICE/registration/"+name, String.class);
//        return result;
//    }
    //Calling Another Microservice Using Feign Client
    @GetMapping("/{name}")
    public String getName(@PathVariable String name){
        String result = registrationService.getName(name);
        return result;
    }
}
