package com.example.study_1.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class HelloApi {
    @GetMapping("hello")
    public String resthello() {
        return "{\"message\":\"hello world!\"}";
    }
    @GetMapping("hi")
    public HashMap<String, Object> resthi() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("message", "hi world!");
        return map;
    }

    @GetMapping("greeting")
    public HashMap<String, Object> greeting(@RequestParam(value = "name", required = false, defaultValue="world") String name) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("message", "hello, " + name + "!");
        return map;
    }

    /*
    curl -X POST -H "Content-Type: application/json" \
    -d '{"name":"yegang"}' \
    http://localhost:8080/api/bye \
    -w "\n"
     */
    @PostMapping("bye")
    public Map<String, Object> bye(@RequestBody(required = false) Map<String, Object> body) {
        Map<String, Object> map = new HashMap<>();
        String name = Optional.ofNullable(body)
                .map(b -> b.get("name"))
                .filter(n -> n instanceof String && !((String) n).isBlank())
                .map(Object::toString)
                .orElse("Anonymous");
        map.put("message", "Good Bye, " + name + "!");
        return map;
    }
}
