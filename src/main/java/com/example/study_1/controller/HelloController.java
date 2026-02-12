package com.example.study_1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!!!!!!!");
        return "hello";
    }
}

// 결과: {"message":"hello world!"}
@RestController
class HelloRestController {
    @GetMapping("resthello")
    public String hello() {
        return "{\"message\":\"hello world!\"}";
    }
}

// 결과: {"message":"hi world!","code":200}
@RestController
class HiRestController {
    @GetMapping("resthi")
    public HashMap<String, Object> hello() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("message", "hi world!");
        map.put("code", 200);
        return map;
    }
}

// 결과: "{message:bye world!}"
@RestController
class ByeRestController {
    @GetMapping("restbye")
    public String bye() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("message", "bye world!");
        return map.toString();
    }
}
