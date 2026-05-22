package com.yegangs.study1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    @ResponseBody
    public String hello() {
        System.out.println("hello");
        return "Hello, Spring Boot!";
    }

    @GetMapping("/")
    public String index() {
        System.out.println("index");
        return "route";
    }
}
