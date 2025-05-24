package com.menglang.spring_webflux.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import java.net.http.HttpClient;

@RestController
public class SwaggerController {

    @GetMapping({"/api/doc","/api/docs"})
    public RedirectView swagger(){
        return  new RedirectView ("/webjars/swagger-ui/index.html",true);
    }
}
