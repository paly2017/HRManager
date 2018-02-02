package com.example.demo.controls;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloControl {
    @RequestMapping("/hello")
    public String hello(){

        return "login";
    }
}
