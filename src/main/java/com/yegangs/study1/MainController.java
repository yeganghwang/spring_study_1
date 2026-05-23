package com.yegangs.study1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @GetMapping("/yegangs")
    @ResponseBody
    public String yegangs() {
        return "Hello! Welcome to yegangs.";
    }

    @GetMapping("/")
    public String index() {
        return "redirect:/question/list";
    }

    @GetMapping("route")
    public String route() {
        return "route";
    }
}
