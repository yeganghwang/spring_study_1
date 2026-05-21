package com.example.study_1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello 하이요");
        model.addAttribute("title", "hello 출력하기");
        model.addAttribute("message", "안녕하세요. 메시지입니다.");
        return "hello";
    }
}
