package com.prakhar.UrlShortener.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.UUID;

@RestController

public class MainController {
    static HashMap<String,String> map=new HashMap<>();
    static HashMap<String,String> revmap=new HashMap<>();
    @GetMapping("/hello")
    public String greet(){
        return "Hello";
    }
    @GetMapping("/geturl")
    public String geturl(){
        return "asf";
    }
    @GetMapping("/bigurl")
    public String bigurl(@RequestParam("bigurl") String big){
        if (revmap.containsKey(big))
            return revmap.get(big);
        String key=UUID.randomUUID().toString();
        map.put(key,big);
        revmap.put(big,key);
        return key;
    }
    @GetMapping("/smallurl")
    public String smallurl(@RequestParam("smallurl") String small){
        return map.getOrDefault(small, "INVALID URL !");
    }
    @GetMapping("/all")
    public Object all(){
        return map;
    }
}
