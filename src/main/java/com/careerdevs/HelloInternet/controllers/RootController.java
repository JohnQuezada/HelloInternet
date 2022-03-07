package com.careerdevs.HelloInternet.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {
    @GetMapping("/")
    public String rootRoute() {
        return "You requested the root route";
    }

}
