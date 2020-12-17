package com.example.database.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
            @RequestParam(value = "password",required=false) String password,
            Model model
    ){

        model.addAttribute("account",account);
        model.addAttribute("name",name);
        model.addAttribute("email",email);
        model.addAttribute("password",password);

        if(account == null || account ==""){
            model.addAttribute("error", "账号不能为空！");
            return "register";
        }

        if(name == null || name ==""){
            model.addAttribute("error", "姓名不能为空！");
            return "register";
        }
        if(email == null || email ==""){
            model.addAttribute("error", "邮箱不能为空！");
            return "register";
        }

        if(password == null || password ==""){
            model.addAttribute("error", "密码不能为空！");
            return "register";
        }



        System.out.println(account+name+email+password);
        return "redirect:/";
    }
}
