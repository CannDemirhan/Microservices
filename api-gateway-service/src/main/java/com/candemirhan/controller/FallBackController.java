package com.candemirhan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fallback")
public class FallBackController {

    @GetMapping("/userService")
    public String userServiceFallBack() {
        return "User Service is taking longer than expected. Please try again later";
    }

    @GetMapping("/departmentService")
    public String departmentServiceFallBack() {
        return "Department Service is taking longer than expected. Please try again later";
    }
}