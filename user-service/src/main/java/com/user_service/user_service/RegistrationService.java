package com.user_service.user_service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "REGISTRATION-SERVICE")
public interface RegistrationService {
    @GetMapping("/registration/{name}")
    String getName(@PathVariable String name);
}
