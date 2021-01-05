package com.example.database.controller;

import com.example.database.model.User;
import com.example.database.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String register(){

        return "register";
    }


    @PostMapping("/register")
    public String doRegister(
            @RequestParam(value = "account",required=false) String account,
            @RequestParam(value = "name",required=false) String name,
            @RequestParam(value = "telephone",required=false) String telephone,
            @RequestParam(value = "password",required=false) String password,
            Model model
    ){

        model.addAttribute("account",account);
        model.addAttribute("name",name);
        model.addAttribute("telephone",telephone);
        model.addAttribute("password",password);

        if(account == null || account ==""){
            model.addAttribute("error", "账号不能为空！");
            return "register";
        }

        if(name == null || name ==""){
            model.addAttribute("error", "姓名不能为空！");
            return "register";
        }
        if(telephone == null || telephone ==""){
            model.addAttribute("error", "邮箱不能为空！");
            return "register";
        }

        if(password == null || password ==""){
            model.addAttribute("error", "密码不能为空！");
            return "register";
        }

        User user = new User();
        user.setAccount(account);
        user.setName(name);
        user.setTelephone(telephone);
        user.setPassword(password);
        userService.createOrUpdate(user);
        return "redirect:/";
    }
}
