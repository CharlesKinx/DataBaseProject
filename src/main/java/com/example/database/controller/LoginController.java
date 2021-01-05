package com.example.database.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class LoginController {


    @RequestMapping("/")
    public String login(){

        return "login";
    }


    @PostMapping("login")
    public String doLogin(
            @RequestParam(value = "account",required=false) String account,
            @RequestParam(value = "password",required=false) String password,
            Model model
                          ){

        model.addAttribute("account",account);
        model.addAttribute("password",password);

        if(account == null || account == ""){
            model.addAttribute("error", "账号不能为空！");
            return "login";
        }
        if(password == null || password == ""){
            model.addAttribute("error", "密码不能为空！");
            return "login";
        }
        System.out.println(account);

        return "redirect:/index";
    }
}
