package com.example.study_1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("math")
public class MathApi {
    @GetMapping("add")
    public Map<String, Object> add(
            @RequestParam(name = "a", required = false, defaultValue = "1") int a,
            @RequestParam(name = "b", required = false, defaultValue = "1") int b
    ) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("method", "add");
        map.put("a", a);
        map.put("b", b);
        map.put("result", a + b);
        return map;
    }
}
