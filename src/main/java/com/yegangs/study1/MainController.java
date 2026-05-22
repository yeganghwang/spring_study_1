package com.yegangs.study1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @GetMapping("/yegangs")
    @ResponseBody
    public String index() {
        System.out.println("yegangs");
        return "Hello! Welcome to yegangs.";
    }
}
