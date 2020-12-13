package com.example.database.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {

    @GetMapping("/register")
    public String register(){

        return "register";
    }


    @PostMapping("/register")
    public String doRegister(
            @RequestParam(value = "account",required=false) String account,
            @RequestParam(value = "name",required=false) String name,
            @RequestParam(value = "email",required=false) String email,
            @RequestParam(value = "password",required=false) String password
    ){

        System.out.println(account+name+email+password);
        return "redirect:/";
    }
}
