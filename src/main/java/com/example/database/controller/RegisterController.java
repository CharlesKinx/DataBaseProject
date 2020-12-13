package com.example.database.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegisterController {
    @RequestMapping("/register")
    public String index(){
        return "register";
    }
}
