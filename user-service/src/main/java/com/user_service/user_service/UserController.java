package com.user_service.user_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user")
public class  UserController {

    private RestTemplate restTemplate;
    @Autowired
    private WebClient.Builder webClient;
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
//    @GetMapping("/{name}")
//    public String getName(@PathVariable String name){
//        String result = registrationService.getName(name);
//        return result;
//    }

    //Calling Another Microservice Using Web Client
//    @GetMapping("/{name}")
//    public Mono<String> getName(@PathVariable String name) {
//         return webClient.build()
//               .get()
//               .uri("http://REGISTRATION-SERVICE/registration/"+name)
//               .retrieve()
//               .bodyToMono(String.class)
//               .doOnNext(System.out::println);
//    }

    //Calling Another Microservice Using Web Flux
    @GetMapping("/{name}")
    public Flux<String> getName(@PathVariable String name) {
        return webClient.build()
                .get()
                .uri("http://REGISTRATION-SERVICE/registration/{name}", name)
                .retrieve()
                .bodyToFlux(String.class) // Flux instead of Mono
                .doOnNext(System.out::println); // Logs response
    }
}
