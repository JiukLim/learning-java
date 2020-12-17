package com.example.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class WebController {

    @GetMapping("/R")
    public String redirector() {
        return "redirect:" + "/hello-view";
    }

    @GetMapping("/hello-view")
    public String index() {
        return "index.html";
    }
}
