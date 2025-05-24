package com.piseth.java.school.webflux_playgroud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/playground")
public class TestingController {
    @GetMapping
    public String testing(){
        return "Greeting Testing....";
    }
}
