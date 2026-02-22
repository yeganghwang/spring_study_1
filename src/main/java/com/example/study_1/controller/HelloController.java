package com.example.study_1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("title", "hello");
        model.addAttribute("data", "hello!!!!!!!!");
        model.addAttribute("korean", "안녕하세요");
        return "hello";
    }

    @GetMapping("bye")
    public String bye(Model model) {
        model.addAttribute("title", "bye");
        model.addAttribute("data", "bye!!!!!!!!");
        model.addAttribute("korean", "안녕히 가세요");
        return "hello";
    }
}
