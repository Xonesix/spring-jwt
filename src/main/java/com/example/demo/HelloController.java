package com.example.demo;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private final HttpServletRequest httpServletRequest;

    public HelloController(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }

    @GetMapping("/")
    public String greeting(HttpServletRequest req) {
        return "I alone am the honored one " + req.getSession().getId();
    }
}
